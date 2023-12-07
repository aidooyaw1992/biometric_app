package com.miaxis.demo.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.miaxis.demo.ApplicationRepository;
import com.miaxis.demo.data.remote.response.Agent;
import com.miaxis.demo.util.DataState;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginViewModel extends ViewModel {
    private static final String TAG = LoginViewModel.class.getSimpleName();

    CompositeDisposable compositeDisposable = new CompositeDisposable();
    private final ApplicationRepository appRepository;
    private final MutableLiveData<DataState<Agent>> dataStateLiveData = new MutableLiveData<>();

    public LiveData<DataState<Agent>> getDataStateLiveData() {
        return dataStateLiveData;
    }

    @Inject
    public LoginViewModel(ApplicationRepository repository) {
        this.appRepository = repository;
    }

    public LiveData<DataState<Agent>> submitLogin(String username, String password) {
        dataStateLiveData.setValue(new DataState<>(DataState.Status.LOADING, null, null));

        Disposable disposable = appRepository.login(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(onSubscribe -> dataStateLiveData.setValue(new DataState<>(DataState.Status.LOADING, null, null)))

                .subscribe(result -> {
                            Agent user = result.get(0);
                            dataStateLiveData.setValue(new DataState<>(DataState.Status.SUCCESS, user, null));
                        },
                        error -> {
                            dataStateLiveData.setValue(new DataState<>(DataState.Status.ERROR, null, "Login was not successful"));
                        }
                );
        compositeDisposable.add(disposable);
        return dataStateLiveData;
    }

    public void sendLoginAnalytics(Agent agentData) {
        Disposable disposable = appRepository
                .sendLoginAnalytics(agentData)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
        compositeDisposable.add(disposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
