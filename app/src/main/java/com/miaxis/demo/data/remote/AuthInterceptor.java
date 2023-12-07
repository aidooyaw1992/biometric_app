package com.miaxis.demo.data.remote;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthInterceptor implements Interceptor {
    private final String accessToken;

    public AuthInterceptor(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public Response intercept(Chain chain) {
        Request originalRequest = chain.request();

        // Add the access token to the request header
        Request newRequest = originalRequest.newBuilder()
                .header("Authorization", "Token " + accessToken)
                .build();
        try {
            return chain.proceed(newRequest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}