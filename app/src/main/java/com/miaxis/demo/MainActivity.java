package com.miaxis.demo;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.miaxis.demo.databinding.ActivityMainBinding;
import com.miaxis.justouch.JustouchFingerAPI;
import com.mx.finger.BuildConfig;
import com.mx.finger.api.sm92.CaptureConfig;
import com.mx.finger.api.sm92.FpPreviewCallBack;
import com.mx.finger.api.sm92.SM92MApi;
import com.mx.finger.api.sm92.SM92MApiFactory;
import com.mx.finger.common.MxImage;
import com.mx.finger.common.Result;
import com.mx.finger.utils.LogUtils;
import com.telpo.tps550.api.fingerprint.FingerPrint;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "Mx-MainActivity";


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

    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private ActivityMainBinding mBinding;
    private JustouchFingerAPI mJustouchApi;
    private SM92MApi mDriverApi;
    private final DiskTemplates mDiskTemplates = new DiskTemplates();
    private int algorithmType = ALGORITHM_ISO;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).setTitle(getString(R.string.app_name) + "-V" + BuildConfig.VERSION_NAME);
        // show all logs
        com.mx.finger.utils.LogUtils.setLogLevel(-1);
        com.miaxis.common.LogUtils.setLogLevel(-1);
        initViews();
        mJustouchApi = new JustouchFingerAPI();
        mDriverApi = SM92MApiFactory.getInstance(this);

        String fpAlgVersion = mJustouchApi.getFpAlgVersion();
        Log.e(TAG, "onCreate: "+fpAlgVersion );
    }

    void initViews() {
        mBinding.openDevice.setOnClickListener(v -> executor.execute(this::openDevice));
        mBinding.closeDevice.setOnClickListener(v -> executor.execute(this::closeDevice));
        mBinding.captureImage.setOnClickListener(v -> executor.execute(this::captureImage));
        mBinding.serialNumber.setOnClickListener(v -> executor.execute(this::serialNumber));
        mBinding.sdkVersion.setOnClickListener(v -> executor.execute(this::sdkVersion));
        mBinding.nfiq.setOnClickListener(v -> executor.execute(this::nfiq));

        mBinding.exportBMP.setOnClickListener(v -> executor.execute(this::exportAsBMP));
        mBinding.exportWSQ.setOnClickListener(v -> executor.execute(this::exportAsWSQ));
        mBinding.exportFIR.setOnClickListener(v -> executor.execute(this::exportAsFIR));
        mBinding.exportFMR.setOnClickListener(v -> executor.execute(this::exportAsFMR));
        mBinding.enroll.setOnClickListener(v -> executor.execute(this::enroll));
        mBinding.verify.setOnClickListener(v -> executor.execute(this::verify));
        mBinding.remove.setOnClickListener(v -> executor.execute(this::remove));
        mBinding.search.setOnClickListener(v -> executor.execute(this::search));
        mBinding.showDB.setOnClickListener(v -> executor.execute(this::showDB));
        mBinding.clear.setOnClickListener(v -> clear());
        mBinding.spinnerLfd.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectLfd = Integer.parseInt(mBinding.spinnerLfd.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mBinding.spinnerLfd.setSelection(2);

        mBinding.spinnerNfiq.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectNfiq = Integer.parseInt(mBinding.spinnerNfiq.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mBinding.spinnerNfiq.setSelection(2);

        mBinding.algSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    changeAlgorithm(ALGORITHM_ISO);
                } else if (position == 1) {
                    changeAlgorithm(ALGORITHM_ISO2011);
                } else if (position == 2) {
                    changeAlgorithm(ALGORITHM_ANSI);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        mBinding.cbLatent.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                showLog("Latent fingerprint detection is enabled");
            } else {
                showLog("Latent fingerprint detection is disabled");
            }
        });
        mBinding.cbLFD.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                showLog("Live fingerprint detection is enabled");
            } else {
                showLog("Live fingerprint detection is disabled");
            }
        });
        mBinding.setOpened(false);
    }

    private void nfiq() {
        try {
            mBinding.setBusy(true);
            showLog("#NFIQ");
            Object oimage = mBinding.imageView.getTag();
            if (!(oimage instanceof MxImage)) {
                showLog("Please get image at first !");
                return;
            }
            MxImage image = ((MxImage) oimage);
            int nfiq = mJustouchApi.getNFIQ(image.data, image.width, image.height);
            if (nfiq >= 1 && nfiq <= 5) {
                String[] NFIQLevel = {"excellent", "veryGood", "good", "fair", "poor"};
                appendLog("Current image's NFIQ  : %s", NFIQLevel[nfiq - 1]);
            } else {
                appendLog("NFIQ error,Code = %d", nfiq);
            }
        } finally {
            mBinding.setBusy(false);
        }
    }

    private void sdkVersion() {
        try {
            mBinding.setBusy(true);
            showLog("SDK version : %s", com.mx.finger.BuildConfig.VERSION_NAME);
            Result<String> result = mDriverApi.getDeviceInfo();
            if (!result.isSuccess()) {
                processError(result);
                return;
            }
            appendLog("Hardware version : %s", result.data);
        } finally {
            appendLog("Justouch version : %s", BuildConfig.VERSION_NAME);
            appendLog("Fp Alg version : %s", mJustouchApi.getFpAlgVersion());
            mBinding.setBusy(false);
        }
    }

    private void serialNumber() {
        try {
            mBinding.setBusy(true);
            showLog("#GetSerialNumber");
            Result<String> result = mDriverApi.getDeviceSerialNumber();
            if (!result.isSuccess()) {
                processError(result);
                return;
            }
            showLog("GetSerialNumber successful!\nSN : %s", result.data);
        } finally {
            mBinding.setBusy(false);
        }
    }


    public void openDevice() {
        FingerPrint.fingerPrintPower(1);
        SystemClock.sleep(4000);
        int i = mDriverApi.openDevice();
        mBinding.setOpened(i > 0);
        if (i < 0) {
            showDialog("Open failed , code : " + i);
            return;
        }
        showLog("Open Successfully");
    }

    public void closeDevice() {
        FingerPrint.fingerPrintPower(0);
        int i = mDriverApi.closeDevice();
        if (i < 0) {
            showDialog("Close failed , code : " + i);
        }
        showLog("Close Successfully");
        mBinding.setOpened(false);
    }

    public void changeAlgorithm(int type) {
        File file = new File(getExternalFilesDir(null), getAlgDirName(type));
        if (!file.exists()) {
            if (!file.mkdirs()) {
                showLog("Init database error ! ");
                return;
            }
        }
        int templateCount = mDiskTemplates.refreshTemplatesFromFile(file.getAbsolutePath());
        this.algorithmType = type;
        if (templateCount >= 0) {
            showLog("Init database successful!\nType : %s \nCount :%d/%d \nFile location :%s ",
                    getAlgName(type), templateCount, DiskTemplates.MAX_FINGER_COUNT, file.getAbsolutePath());
        } else {
            showLog("Init database error ! ");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        FingerPrint.fingerPrintPower(0);
    }

    public void captureImage() {
        try {
            mBinding.setBusy(true);
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
            mBinding.setBusy(false);
        }
    }

    public void verify() {
        showLog("#Verify");
        String id = mBinding.input.getText().toString();
        if (TextUtils.isEmpty(id)) {
            showLog("Verify failed!\nPlease input you id ");
            return;
        }

        byte[] selectTemplate = mDiskTemplates.get(id);
        if (selectTemplate == null) {
            showLog("Verify failed!\nReason : Not found id %s", id);
            return;
        }

        try {
            mBinding.setBusy(true);
            long timeStart = System.currentTimeMillis();
            byte[] tempFeature = new byte[DiskTemplates.TEMPLATE_LENGTH];
            Result<MxImage> image = captureImageFromDevice();
            if (!image.isSuccess()) {
                processError(image);
                return;
            }

            long timeCaptureEnd = System.currentTimeMillis();
            assert image.data != null;
            int result = createTemplate(image.data.data, image.data.width, image.data.height, tempFeature, false, null);
            if (result < 0) {
                showLog("Verify failed!\nReason : get new template failed!\nCode : %d", result);
                return;
            }

            int score = compareTemplates(selectTemplate, tempFeature);
            long timeEnd = System.currentTimeMillis();
            if (score >= 45) {
                showLog("Verify successful !\nSimilar score : %d\nCapture Time : %d ms\nVerify Time : %d ms", score, timeCaptureEnd - timeStart, timeEnd - timeCaptureEnd);
            } else if (score >= 0) {
                showLog("Verify failed !\nSimilar score : %d\nCapture Time : %d ms\nVerify Time : %d ms", score, timeCaptureEnd - timeStart, timeEnd - timeCaptureEnd);
            } else {
                showLog("Verify error !\nCode : %s\nTime : %s", score, timeEnd - timeStart);
            }
        } finally {
            mBinding.setBusy(false);
        }

    }

    public void enroll() {
        showLog("#Enroll");
        String id = mBinding.input.getText().toString();
        if (TextUtils.isEmpty(id)) {
            showLog("Enroll failed!\nPlease input you id ");
            return;
        }
        try {
            mBinding.setBusy(true);
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
            ;
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
            mBinding.setBusy(false);
        }
    }

    public void remove() {
        showLog("#Remove");
        String id = mBinding.input.getText().toString();
        if (TextUtils.isEmpty(id)) {
            showLog("Remove failed !\nPlease input you id ");
            return;
        }
        mBinding.setBusy(true);
        boolean delete = mDiskTemplates.delete(id);
        if (delete) {
            showLog("Remove successful , id : %s", id);
        } else {
            showLog("Remove failed!\nReason : Not found id %s", id);
        }
        mBinding.setBusy(false);
    }

    public void search() {
        showLog("#Search");
        try {
            mBinding.setBusy(true);
            long timeCaptureStart = System.currentTimeMillis();
            Result<MxImage> image = captureImageFromDevice();
            long timeCaptureEnd = System.currentTimeMillis();
            if (!image.isSuccess()) {
                processError(image);
                return;
            }
            assert image.data != null;
            byte[] newTemplate = new byte[1024];
            int createResult = createTemplate(image.data.data, image.data.width, image.data.height, newTemplate, false, null);
            if (createResult < 0) {
                showLog("Search Error  !\nCode : %d", createResult);
                return;
            }

            long timeStartSearch = System.currentTimeMillis();
            int index = searchTemplates(newTemplate, mDiskTemplates.count(), mDiskTemplates.getAll());
            long timeEndSearch = System.currentTimeMillis();
            if (index >= 0) {
                String id = mDiskTemplates.getId(index);
                showLog("Search successful !\nId : %s\nCapture Time : %d ms \nSearch Time : %d ms", id, timeCaptureEnd - timeCaptureStart, timeEndSearch - timeStartSearch);
            } else {
                showLog("Search failed  ! \nCapture Time : %d ms \nSearch Time : %d ms", timeCaptureEnd - timeCaptureStart, timeEndSearch - timeStartSearch);
            }
        } finally {
            mBinding.setBusy(false);
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

    public void clear() {
        final String typeName = getAlgName(algorithmType);
        new AlertDialog.Builder(this)
                .setTitle("Notice")
                .setMessage(String.format("Do you want to delete all %s template ?", typeName))
                .setPositiveButton("YES", (dialog, which) ->
                        executor.execute(() -> {
                            showLog("#Clear");
                            mDiskTemplates.clear();
                            showLog("Clear all %s template successful", typeName);
                        }))
                .setNegativeButton("Cancel", null)
                .show();
    }

    public void showDB() {
        String ids = mDiskTemplates.getIds();
        showLog("Show Enrolled User successful!\n%s", ids);
    }

    private void exportAsBMP() {
        showLog("#ExportAsBMP");
        Object image = mBinding.imageView.getTag();
        if (!(image instanceof MxImage)) {
            showLog("Please get image at first !");
            return;
        }
        MxImage mxImage = ((MxImage) image);
        mBinding.setBusy(true);
        byte[] bmpData = new byte[mxImage.width * mxImage.height + 1087];

        long result = mJustouchApi.convertRawToBMP(mxImage.data, mxImage.width, mxImage.height, bmpData);
        if (result == 0) {
            String path = saveFile(BMP_NAME, bmpData, bmpData.length);
            showLog("ExportAsBMP successful!\nFile Size : %d \nFilePath : %s ", bmpData.length, path);
        } else {
            showLog("ExportAsBMP failed!\nCode = %d", result);
        }
        mBinding.setBusy(false);
    }

    private void exportAsWSQ() {
        showLog("#ExportAsWSQ");
        Object image = mBinding.imageView.getTag();
        if (!(image instanceof MxImage)) {
            showLog("Please get image at first !");
            return;
        }
        MxImage mxImage = ((MxImage) image);
        mBinding.setBusy(true);
        byte[] wsq = new byte[15 * 1024];
        int[] wsqLen = new int[1];
        long result = mJustouchApi.compressWSQBySize(mxImage.data, mxImage.width, mxImage.height, 500, 10 * 1024, 15 * 1024, wsq, wsqLen);
        if (result == 0) {
            String path = saveFile(WSQ_NAME, wsq, wsqLen[0]);
            showLog("ExportAsWSQ successful!\nFile Size : %s \nFilePath : %s ", wsqLen[0], path);
        } else {
            showLog("ExportAsWSQ failed!\nCode = %d", result);
        }
        mBinding.setBusy(false);
    }

    private void exportAsFIR() {
        showLog("#ExportAsFIR");
        Object image = mBinding.imageView.getTag();
        if (!(image instanceof MxImage)) {
            showLog("Please get image at first !");
            return;
        }
        MxImage mxImage = ((MxImage) image);
        mBinding.setBusy(true);
        byte[] outBuffer = new byte[mxImage.data.length];
        int[] outDataLength = new int[1];
        long result = mJustouchApi.makeFIR(mxImage.data, mxImage.width, mxImage.height,
                COMPRESSION_TYPE_JP2, 1, outBuffer, outDataLength);
        if (result == 0) {
            String path = saveFile(FIR_NAME, outBuffer, outDataLength[0]);
            showLog("ExportAsFIR(FIR with JPEG2000 lossless) successful!\nFile Size : %s \nFilePath : %s ", outDataLength[0], path);
        } else {
            showLog("ExportAsFIR failed!\nCode = %d", result);
        }
        mBinding.setBusy(false);
    }


    private void exportAsFMR() {
        showLog("#ExportAsFMR");
        Object image = mBinding.imageView.getTag();
        if (!(image instanceof MxImage)) {
            showLog("Please get image at first !");
            return;
        }
        MxImage mxImage = ((MxImage) image);
        mBinding.setBusy(true);
        byte[] template = new byte[DiskTemplates.TEMPLATE_LENGTH];
        int[] templateLength = new int[1];
        int result = createTemplate(mxImage.data, mxImage.width, mxImage.height, template, false, templateLength);
        if (result == 0) {
            String path = saveFile(FMR_NAME, template, templateLength[0]);
            showLog("ExportAsFMR(%s) successful!\nFile Size : %s \nFilePath : %s ", getAlgName(algorithmType), templateLength[0], path);
        } else {
            showLog("ExportAsFMR failed!\nCode = %d", result);
        }
        mBinding.setBusy(false);
    }


    public void loadFIR() {
        showLog("#DecompressFIR");
        clearFingerImage();
        byte[] dataBuffer = loadFile(FIR_NAME);
        if (dataBuffer == null) {
            showLog("Error : Not found FIR file with name %s", FIR_NAME);
            return;
        }
        byte[] imageBuffer = new byte[400 * 500];
        int[] width = new int[1];
        int[] height = new int[1];
        int[] dpi = new int[1];
        int[] compressionType = new int[1];
        long result = mJustouchApi.unmakeFIR(dataBuffer, imageBuffer, width, height, dpi, compressionType);
        showFingerImage(new MxImage(imageBuffer, width[0], height[0]));
        if (result == 0) {
            showLog("DecompressFIR successful!\nImage is updated .");
        } else {
            showLog("DecompressFIR failed!\nCode : %d", result);
        }
    }

    public void loadWSQ() {
        showLog("#UncompressWSQ");
        clearFingerImage();
        byte[] wsqBuffer = loadFile(WSQ_NAME);
        if (wsqBuffer == null) {
            showLog("Error : Not found WSQ file with name %s", WSQ_NAME);
            return;
        }
        // FAP30
        byte[] imageBuffer = new byte[400 * 500];
        int[] width = new int[1];
        int[] height = new int[1];
        int[] dpi = new int[1];
        long result = mJustouchApi.decompressWSQ(wsqBuffer, wsqBuffer.length, imageBuffer, width, height, dpi);
        showFingerImage(new MxImage(imageBuffer, width[0], height[0]));
        if (result == 0) {
            showLog("UncompressWSQ successful!\nImage is updated .");
        } else {
            showLog("UnCompressWSQ failed!\nCode : %d", result);
        }
    }

    private Result<MxImage> captureImageFromDevice() {
        boolean latent = mBinding.cbLatent.isChecked();
        boolean lfd = mBinding.cbLFD.isChecked();

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
        Log.e("image===","" + image.code);

     /*   if (image.isSuccess()) {
//        if (captureConfig.getAESStatus() != CaptureConfig.AES_NONE) {
//            // decrypt
//        }
            showFingerImage(image.data);

            assert image.data != null;
            int nfiq = mJustouchApi.getNFIQ(image.data.data, image.data.width, image.data.height);
            // NFIQ==5 is poor
            if (nfiq < 1 || nfiq > 4) {
                return Result.error(ERR_NFIQ);
            }
        }*/
        return image;
    }

    private final FpPreviewCallBack previewCallBack = (sm92MApi, captureConfig, mxImage) -> {
//        if (captureConfig.getAESStatus() != CaptureConfig.AES_NONE) {
//            // decrypt
//            return;
//        }
        showFingerImage(mxImage);
    };

    private int createTemplate(byte[] data, int width, int height, byte[] newTemplate, boolean ex, int[] length) {
        if (algorithmType == ALGORITHM_ISO) {
            return mJustouchApi.createTemplateISO(data, width, height, MIN_MINUTIAE_COUNT, newTemplate, ex, length);
        } else if (algorithmType == ALGORITHM_ISO2011) {
            return mJustouchApi.createTemplateISO2011(data, width, height, MIN_MINUTIAE_COUNT, newTemplate, ex, length);
        } else {
            return mJustouchApi.createTemplateANSI(data, width, height, MIN_MINUTIAE_COUNT, newTemplate, ex, length);
        }
    }

    private int compareTemplates(byte[] data, byte[] dataAnother) {
        if (algorithmType == ALGORITHM_ISO) {
            return mJustouchApi.compareTemplatesISO(data, dataAnother);
        } else if (algorithmType == ALGORITHM_ISO2011) {
            return mJustouchApi.compareTemplatesISO2011(data, dataAnother);
        } else {
            return mJustouchApi.compareTemplatesANSI(data, dataAnother);
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

    private String getAlgName(int algorithmType) {
        String[] textArray = getResources().getStringArray(R.array.alg_type_name);
        return textArray[algorithmType];
    }

    private String getAlgDirName(int algorithmType) {
        String[] textArray = getResources().getStringArray(R.array.alg_type_dir_name);
        return textArray[algorithmType];
    }

    void clearFingerImage() {
        mBinding.imageView.setTag(null);
        runOnUiThread(() -> mBinding.imageView.setImageResource(R.drawable.ic_fingerprint));
    }

    void showFingerImage(MxImage image) {
        runOnUiThread(() -> {
            mBinding.imageView.setTag(image);
            if (image == null) {
                mBinding.imageView.setImageResource(R.drawable.ic_fingerprint);
            } else {
                byte[] bytes = new byte[image.width * image.height + 1087];
                mJustouchApi.convertRawToBMP(image.data, image.width, image.height, bytes);
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                mBinding.imageView.setImageBitmap(bitmap);
            }
        });
    }

    @SuppressLint("SetTextI18n")
    void showLog(String fmt, Object... data) {
        String msg = String.format(fmt, data);
        LogUtils.e(TAG, "showLog: " + msg);
        mBinding.setHint(msg + "\n");
    }

    void appendLog(String fmt, Object... data) {
        String msg = String.format(fmt, data);
        LogUtils.e(TAG, "appendLog: " + msg);
        msg = mBinding.getHint() + msg;
        mBinding.setHint(msg + "\n");
    }

    @SuppressLint("SetTextI18n")
    void showDialog(String msg) {
        showLog(msg);
        runOnUiThread(() ->
                new AlertDialog.Builder(this)
                        .setTitle("Warning")
                        .setMessage(msg)
                        .setPositiveButton("OK", null)
                        .show());
    }


    String saveFile(String filename, byte[] buffer, int len) {
        try {
            File filesDir = getExternalFilesDir(null);
            File file = new File(filesDir, filename);
            FileOutputStream out = new FileOutputStream(file);
            out.write(buffer, 0, len);
            out.close();
            return file.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    byte[] loadFile(String filename) {
        File filesDir = getExternalFilesDir(null);
        File file = new File(filesDir, filename);
        try {
            FileInputStream out = new FileInputStream(file);
            int available = out.available();
            byte[] buffer = new byte[available];
            int ret = out.read(buffer);
            out.close();
            if (ret != available) {
                return null;
            }
            return buffer;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
