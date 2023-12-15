package com.miaxis.demo.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.miaxis.demo.DiskTemplates;
import com.miaxis.demo.R;
import com.miaxis.demo.data.remote.response.PensionData;
import com.miaxis.demo.databinding.ActivityRegisterBiometricBinding;
import com.miaxis.demo.util.UploadWorker;
import com.miaxis.justouch.JustouchFingerAPI;
import com.mx.finger.api.sm92.CaptureConfig;
import com.mx.finger.api.sm92.FpPreviewCallBack;
import com.mx.finger.api.sm92.SM92MApi;
import com.mx.finger.api.sm92.SM92MApiFactory;
import com.mx.finger.common.MxImage;
import com.mx.finger.common.Result;
import com.mx.finger.utils.LogUtils;
import com.telpo.tps550.api.fingerprint.FingerPrint;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RegisterBiometricActivity extends AppCompatActivity {
    private static final String TAG = RegisterBiometricActivity.class.getSimpleName();

    ActivityRegisterBiometricBinding binding;

    private SM92MApi mDriverApi;
    private JustouchFingerAPI mJustouchApi;
    /**
     * Minimum acceptable number of fingerprint minutiae points
     */
    private static final int MIN_MINUTIAE_COUNT = 12;
    private static final int ERR_NFIQ = -3002;
    /**
     * Default
     */
    private static final int ALGORITHM_ISO = 0;
    private static final int ALGORITHM_ISO2011 = 1;
    private static final int ALGORITHM_ANSI = 2;
    private static final int COMPRESSION_TYPE_WSQ = 2;
    private static final int COMPRESSION_TYPE_JP2 = 4;

    private static final String FIR_NAME = "image.fir";
    private static final String FMR_NAME = "image.fmr";
    private static final String WSQ_NAME = "image.wsq";
    private static final String BMP_NAME = "image.bmp";
    private int selectLfd = 3;
    private int selectNfiq = 3;

    final DiskTemplates mDiskTemplates = new DiskTemplates();
    private int algorithmType = ALGORITHM_ISO;

    private WorkManager mWorkManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBiometricBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.registerViewToolbar);
        mWorkManager = WorkManager.getInstance(getApplicationContext());
        mJustouchApi = new JustouchFingerAPI();
        mDriverApi = SM92MApiFactory.getInstance(this);
        com.mx.finger.utils.LogUtils.setLogLevel(-1);
        com.miaxis.common.LogUtils.setLogLevel(-1);

        Intent intent = getIntent();
        PensionData user = (PensionData) intent.getSerializableExtra("data");
        binding.itemUserId.setText(user != null ? String.valueOf(user.getValue().get(0).getNo()) : "No ID");
        binding.itemFullName.setText(user != null ? formatTitle(user.getValue().get(0).getTitle()) + " " + user.getValue().get(0).getFirstName() + " " + user.getValue().get(0).getLastName() : "No Name");
        binding.inactiveDate.setText(user != null ? user.getValue().get(0).getInactiveDate() : "N/A");


        binding.btnEnrolFingerprint.setOnClickListener(v -> {
            enroll();
//           simulateAsyncOperation()
//                   .subscribeOn(Schedulers.io())
//                   .doOnSubscribe(disposable -> {
//                       Log.d(TAG, "onSubscribe: running");
//                   })
//                   .observeOn(AndroidSchedulers.mainThread())
//
//                   .doOnComplete(() ->{
//                       Log.d(TAG, "simulateAsyncOperation: completed");
//                       showDialog("Upload Success");
//                   })
//
//                   .subscribe();
        });

        testWorkManager(mWorkManager);
        binding.btnCaptureFingerprint.setOnClickListener(v -> captureImage());

        binding.openDevice.setOnClickListener(v -> {
            openDeviceAsync()
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSuccess(result -> {
                        Log.d(TAG, "onCreate: success");
                        if (result > 0) {
                            shouldEnableButtons(true);
                            Toast.makeText(this, "opened successfully", Toast.LENGTH_SHORT).show();
                        } else {
                            shouldEnableButtons(false);
                            showDialog("failed to opened " + String.valueOf(result));
                            Toast.makeText(this, "failed to opened", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .doOnError(throwable -> {
                        shouldEnableButtons(false);
                        Log.e(TAG, "onCreate: on error", throwable);
                    })
                    .subscribe();
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.clear_image_db:
                clear();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    private void testWorkManager(WorkManager workManager) {
        workManager.enqueue(OneTimeWorkRequest.from(UploadWorker.class));
    }

    private Completable simulateAsyncOperation() {
        Log.d(TAG, "simulateAsyncOperation: started");
        // Simulate an asynchronous operation with a delay of 2 seconds
        return Completable.timer(2000, java.util.concurrent.TimeUnit.MILLISECONDS);

    }

    private String formatTitle(String title) {
        return title.substring(0, 1).toUpperCase() + title.substring(1).toLowerCase();
    }

    private String getAlgName(int algorithmType) {
        String[] textArray = getResources().getStringArray(R.array.alg_type_name);
        return textArray[algorithmType];
    }

    void setBusy(boolean state) {
        shouldEnableButtons(!state);
    }

    void clearFingerImage() {
        binding.fingerprintPlaceholder.setTag(null);
        binding.fingerprintPlaceholder.setImageResource(R.drawable.ic_fingerprint);
    }

    public void captureImage() {
        try {
            setBusy(true);
            clearFingerImage();
            showLog("#GetFingerImage");
            long st = System.currentTimeMillis();
            Result<MxImage> result = captureImageFromDevice();
            if (!result.isSuccess()) {
                processError(result);
                return;
            }
            showLog("GetFingerImage successful!\nImage is updated .Time : %s ms", (System.currentTimeMillis() - st));
        } finally {
            setBusy(false);
        }
    }

    public void enroll() {
        Log.d(TAG, "enroll: enroll started");
        String id = binding.input.getText().toString();
        if (TextUtils.isEmpty(id)) {
            showLog("Enroll failed!\nPlease input you id ");
            Toast.makeText(this, "Please input you id", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            setBusy(true);
            long timeStart = System.currentTimeMillis();
            byte[] tempFeature = new byte[DiskTemplates.TEMPLATE_LENGTH];
            Result<MxImage> image = captureImageFromDevice();
            if (!image.isSuccess()) {
                processError(image);
                return;
            }
            long timeCaptureEnd = System.currentTimeMillis();
            assert image.data != null;
            int[] templateLength = new int[1];
            int result = createTemplate(image.data.data, image.data.width, image.data.height, tempFeature, false, templateLength);
            if (result < 0) {
                showLog("Enroll failed!\nReason : get new template failed!\nCode : %d", result);
                return;
            }

            showLog("#Enroll search ");
            int index = searchTemplates(tempFeature, mDiskTemplates.count(), mDiskTemplates.getAll());

            long timeEnd = System.currentTimeMillis();
            if (index >= 0) {
                String id1 = mDiskTemplates.getId(index);
                showLog("Enroll failed!\nReason : The fingerprint has been enrolled , id is %s", id1);
            } else {
                boolean addToDbSuccess = mDiskTemplates.put(id, Arrays.copyOf(tempFeature, templateLength[0]));
                if (!addToDbSuccess) {
                    showLog("Enroll failed!\nReason : The id has been enrolled , Please re-enter id");
                } else {
                    showLog("Enroll successful !\nEnroll id : %s\nCapture Time : %d ms\nEnroll Time : %d ms", id, timeCaptureEnd - timeStart, timeEnd - timeCaptureEnd);
                }
            }
        } finally {
            setBusy(false);
        }
    }

    private final FpPreviewCallBack previewCallBack = (sm92MApi, captureConfig, mxImage) -> {
        showFingerImage(mxImage);
    };

    void showFingerImage(MxImage image) {
        runOnUiThread(() -> {
            binding.fingerprintPlaceholder.setTag(image);
            if (image == null) {
                binding.fingerprintPlaceholder.setImageResource(R.drawable.ic_fingerprint);
            } else {
                byte[] bytes = new byte[image.width * image.height + 1087];
                mJustouchApi.convertRawToBMP(image.data, image.width, image.height, bytes);
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                binding.fingerprintPlaceholder.setImageBitmap(bitmap);
            }
        });
    }

    private int createTemplate(byte[] data, int width, int height, byte[] newTemplate, boolean ex, int[] length) {
        if (algorithmType == ALGORITHM_ISO) {
            return mJustouchApi.createTemplateISO(data, width, height, MIN_MINUTIAE_COUNT, newTemplate, ex, length);
        } else if (algorithmType == ALGORITHM_ISO2011) {
            return mJustouchApi.createTemplateISO2011(data, width, height, MIN_MINUTIAE_COUNT, newTemplate, ex, length);
        } else {
            return mJustouchApi.createTemplateANSI(data, width, height, MIN_MINUTIAE_COUNT, newTemplate, ex, length);
        }
    }

    private int searchTemplates(byte[] templateToSearch,
                                int numberOfDbTemplates,
                                byte[] arrayOfDbTemplates) {
        if (algorithmType == ALGORITHM_ISO) {
            return mJustouchApi.searchTemplatesISO(templateToSearch, numberOfDbTemplates, arrayOfDbTemplates);
        } else if (algorithmType == ALGORITHM_ISO2011) {
            return mJustouchApi.searchTemplatesISO2011(templateToSearch, numberOfDbTemplates, arrayOfDbTemplates);
        } else {
            return mJustouchApi.searchTemplatesANSI(templateToSearch, numberOfDbTemplates, arrayOfDbTemplates);
        }
    }

    private void processError(Result<?> image) {
//        clearFingerImage();
        switch (image.code) {
            case SM92MApi.ERR_TIMEOUT:
                appendLog("Failed !\nTimeout!");
                break;
            case SM92MApi.ERR_LATENT_INIT:
                appendLog("Failed !\nLatent reject library init failed , please check your .so file ");
                break;
            case SM92MApi.ERR_LFD_INIT:
                appendLog("Failed !\nLFD library init failed , please check your .so file ");
                break;
            case SM92MApi.ERR_LATENT_REJECT:
                appendLog("Failed !\nLatent reject !");
                break;
            case SM92MApi.ERR_LFD_REJECT:
                appendLog("Failed !\nLFD reject !");
                break;
            case SM92MApi.ERR_QUALITY_LEVEL:
                appendLog("Failed !\nNFIQ reject !");
                break;
            default:
                appendLog("Failed !\nCode : %d", image.code);
        }
    }

    private Result<MxImage> captureImageFromDevice() {
//        boolean latent = mBinding.cbLatent.isChecked();
//        boolean lfd = mBinding.cbLFD.isChecked();
        boolean latent = false;
        boolean lfd = false;

        Log.e("selectLfd", "" + selectLfd);
        CaptureConfig captureConfig = new CaptureConfig.Builder()
                .setLfdLevel(lfd ? selectLfd : 0)
                .setLatentLevel(latent ? 3 : 0)
                .setQualityLevel(selectNfiq)
                .setTimeout(CaptureConfig.DEFAULT_TIMEOUT)
                .setAreaScore(CaptureConfig.DEFAULT_AREA_SCORE)
                .setPreviewCallBack(previewCallBack)
                // AES/ECB/PKCS5Padding
                //.setAESConfig(new AESConfig.Builder().setKey("1234567890123456").build())
                //.setAESStatus(CaptureConfig.AES_HOST)
                .build();
        Result<MxImage> image = mDriverApi.getImage(captureConfig);
        Log.e("image===", "" + image.code);
        return image;
    }

    public void clearDiskTemplate() {
            mDiskTemplates.clear();
            showLog("Clear all %s template successful");
    }


    public void clear() {
        final String typeName = getAlgName(algorithmType);


        new AlertDialog.Builder(this)
                .setTitle("Notice")
                .setMessage(String.format("Do you want to delete all %s template ?", typeName))
                .setPositiveButton("YES", (dialog, which) -> {
                    runOnUiThread(this::clearDiskTemplate);
                })
                .setNegativeButton("Cancel", null)
                .show();

    }

    void showLog(String fmt, Object... data) {
        String msg = String.format(fmt, data);
        LogUtils.e(TAG, "showLog: " + msg);
        binding.log.setHint(msg + "\n");
    }

    void appendLog(String fmt, Object... data) {
        String msg = String.format(fmt, data);
        LogUtils.e(TAG, "appendLog: " + msg);
        msg = binding.log.getHint() + msg;
        binding.log.setHint(msg + "\n");
    }

    void shouldEnableButtons(boolean state) {
        binding.btnEnrolFingerprint.setEnabled(state);
        binding.btnCaptureFingerprint.setEnabled(state);
    }

    private Single<Integer> openDeviceAsync() {
        return Single
                .fromCallable(() -> {
                    FingerPrint.fingerPrintPower(1);
                    SystemClock.sleep(4000);
                    return mDriverApi.openDevice();
                })
                .subscribeOn(Schedulers.io());
    }

    void showDialog(String msg) {
        showLog(msg);
        runOnUiThread(() ->
                new AlertDialog.Builder(this)
                        .setTitle("Warning")
                        .setMessage(msg)
                        .setPositiveButton("OK", null)
                        .show());
    }
}