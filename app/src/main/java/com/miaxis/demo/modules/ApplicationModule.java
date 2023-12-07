package com.miaxis.demo.modules;

import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor;
import com.miaxis.demo.ApplicationRepository;
import com.miaxis.demo.data.remote.AuthInterceptor;
import com.miaxis.demo.data.remote.PensionApi;
import com.miaxis.demo.util.NtlmAuthenticator;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApplicationModule {
//    private static final String BASE_URL = "http://ghpensions.com:7048/";
    private static final String BASE_URL = "http://209.38.240.172:8080/";
    private static final String AUTH_TOKEN ="bb18a0fcff311a5a96279b81f4e7464eb0d0f357";
    @Singleton
    @Provides
    public Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }



    @Singleton
    @Provides
    public OkHttpClient provideOkHttp() {
        return new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor(new OkHttpProfilerInterceptor())
                .addInterceptor(new AuthInterceptor(AUTH_TOKEN))
                .connectTimeout(60*100, TimeUnit.SECONDS)
                .readTimeout(60*100, TimeUnit.SECONDS)
                .writeTimeout(60*100, TimeUnit.SECONDS)
                .followRedirects(true)
                .retryOnConnectionFailure(true)
                .build();
    }

    @Singleton
    @Provides
    public PensionApi providePensionApi(Retrofit retrofit) {
        return retrofit.create(PensionApi.class);
    }

    @Singleton
    @Provides
    public ApplicationRepository provideAppRepository(PensionApi api) {
        return new ApplicationRepository(api); // Provide your actual repository implementation
    }
}