package com.miaxis.demo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;


import com.miaxis.demo.data.remote.response.Agent;
import com.miaxis.demo.databinding.ActivitySplashBinding;
import com.miaxis.demo.util.MySharedPreferences;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SplashActivity extends AppCompatActivity {
    private static final String TAG = SplashActivity.class.getSimpleName();

    ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int delaySeconds = 2;

        Observable.timer(delaySeconds, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(aLong -> {
                    if (!checkAuthentication()) {
                        Log.d(TAG, "onCreate: redirecting to login screen");
                        // If not authenticated, redirect to the login screen or take appropriate action
                        redirectToLoginScreen();
                    } else {
                        gotoHomePage();
                    }
                    return Observable.empty();
                })
                .subscribe();

    }


    private void gotoHomePage() {
        Intent loginIntent = new Intent(this, HomeActivity.class);
        startActivity(loginIntent);
        finish();
    }

    private boolean checkAuthentication() {
        Agent savedAgent = MySharedPreferences.getUser(getApplicationContext());
        // Log.d(TAG, "checkAuthentication: "+ savedAgent == null ?"Nothing found":savedAgent.toJson());
        return savedAgent != null;
    }

    private void redirectToLoginScreen() {
        Intent loginIntent = new Intent(this, LoginActivity.class);
        startActivity(loginIntent);
        finish();
    }
}