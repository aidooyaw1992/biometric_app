package com.miaxis.demo;

import com.miaxis.demo.data.remote.PensionApi;
import com.miaxis.demo.data.remote.response.Agent;
import com.miaxis.demo.data.remote.response.LoginAnalyticsModel;
import com.miaxis.demo.data.remote.response.PensionData;

import java.util.List;
import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

public class ApplicationRepository {
    private final PensionApi pensionApi;

    @Inject
    public ApplicationRepository(PensionApi pensionApi) {
        this.pensionApi = pensionApi;
    }

    public Single<List<PensionData>> getUsers() {
        return pensionApi.getUsers();
    }
    public Single<PensionData> getUserById(String value) {
        return pensionApi.getUserById(value);
    }
    public Completable sendLoginAnalytics(Agent value) {
        System.out.println("MyMethod implementation in MyClass");
        LoginAnalyticsModel model = new LoginAnalyticsModel(
                value.getUserid(),"login_activity", "login_activity");
        return pensionApi.loginAnalytics(model);
    }

    public Single<List<Agent>> login(String username, String password) {
      return pensionApi.loginAgent(username, password);
    }


}
