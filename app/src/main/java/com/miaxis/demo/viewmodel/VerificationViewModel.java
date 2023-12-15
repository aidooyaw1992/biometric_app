package com.miaxis.demo.viewmodel;

import androidx.lifecycle.ViewModel;

import com.miaxis.demo.ApplicationRepository;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class VerificationViewModel extends ViewModel {
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    private final ApplicationRepository appRepository;

    @Inject
    public VerificationViewModel(ApplicationRepository appRepository) {
        this.appRepository = appRepository;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
