package com.miaxis.demo.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.miaxis.demo.PensionApplication;
import com.miaxis.demo.databinding.ActivityHomeBinding;
import com.miaxis.demo.viewmodel.HomeViewModel;

import javax.inject.Inject;
public class HomeActivity extends AppCompatActivity {
    @Inject
    HomeViewModel viewModel;
    private static final String TAG = HomeActivity.class.getSimpleName();

    private ActivityHomeBinding binding;
    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ((PensionApplication) getApplicationContext()).getAppComponent().inject(this);

        binding.cvEnrolBiometric.setOnClickListener(v -> {
            gotoVerificationPage();
        });

    }


    void gotoVerificationPage() {
        Intent vIntent = new Intent(this, SearchActivity.class);
        startActivity(vIntent);
    }

    public static AlertDialog showDialog(@NonNull Context context, @NonNull String title, @NonNull String msg,
                                         @NonNull String positiveBtnText,
                                         @NonNull DialogInterface.OnClickListener positiveBtnClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(msg)
                .setCancelable(true)
                .setPositiveButton(positiveBtnText, positiveBtnClickListener);
        AlertDialog alert = builder.create();
        alert.show();
        return alert;
    }
}