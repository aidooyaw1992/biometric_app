package com.miaxis.demo;

import android.app.Application;

import com.miaxis.demo.modules.ApplicationComponent;
import com.miaxis.demo.modules.ApplicationModule;
import com.miaxis.demo.modules.DaggerApplicationComponent;

public class PensionApplication extends Application {
    private ApplicationComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule())
                .build();
    }

    public ApplicationComponent getAppComponent() {
        return appComponent;
    }
}
