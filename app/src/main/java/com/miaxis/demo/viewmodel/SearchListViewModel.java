package com.miaxis.demo.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.miaxis.demo.ApplicationRepository;
import com.miaxis.demo.data.remote.response.PensionData;
import com.miaxis.demo.util.DataState;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SearchListViewModel extends ViewModel {
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    private final ApplicationRepository appRepository;
    private final MutableLiveData<DataState<List<PensionData>>> dataStateLiveData = new MutableLiveData<>();

    public LiveData<DataState<List<PensionData>>> getDataStateLiveData() {
        return dataStateLiveData;
    }
    @Inject
    public SearchListViewModel(ApplicationRepository repository) {
        this.appRepository = repository;
    }

    public LiveData<DataState<List<PensionData>>> getUsers(String value) {
        dataStateLiveData.setValue(new DataState<>(DataState.Status.LOADING, null, null));

        Disposable disposable = appRepository.getUserById(value)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(onSubscribe ->dataStateLiveData.setValue(new DataState<>(DataState.Status.LOADING, null, null)))

                .subscribe( result -> {
                            ArrayList<PensionData> userList = new ArrayList<>();
                            userList.add(result);
                            dataStateLiveData.setValue(new DataState<>(DataState.Status.SUCCESS, userList, null));
                        },
                        error -> {
                            dataStateLiveData.setValue(new DataState<>(DataState.Status.ERROR, null, "Request was not successful"));
                        }
                );
        compositeDisposable.add(disposable);
        return  dataStateLiveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
