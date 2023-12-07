package com.miaxis.demo.viewmodel;

import androidx.lifecycle.ViewModel;
import com.miaxis.demo.ApplicationRepository;
import com.miaxis.demo.ui.HomeActivity;
import javax.inject.Inject;
import io.reactivex.disposables.CompositeDisposable;


public class HomeViewModel extends ViewModel {

    private static final String TAG = HomeActivity.class.getSimpleName();
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    private final ApplicationRepository appRepository;

    @Inject
    public HomeViewModel(ApplicationRepository repository) {
        this.appRepository = repository;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
