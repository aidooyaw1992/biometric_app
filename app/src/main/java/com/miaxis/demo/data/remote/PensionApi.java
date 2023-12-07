package com.miaxis.demo.data.remote;

import com.miaxis.demo.data.remote.response.Agent;
import com.miaxis.demo.data.remote.response.LoginAnalyticsModel;
import com.miaxis.demo.data.remote.response.PensionData;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface PensionApi {
    @GET("aidooyaw1992/demo/db")
    Single<List<PensionData>> getUsers();

    @GET("nav_api/get-employee/{user_id}")
    Single<PensionData> getUserById(@Path(value="user_id") String id);


    @GET("https://ghpensions.com/pensions/pension-api")
    Single<List<Agent>> loginAgent(@Query("username") String username, @Query("password") String password);

    @POST("https://ghpensions.com/pensions/pension-api")
    Completable loginAnalytics(@Body LoginAnalyticsModel analyticsModel);
}
