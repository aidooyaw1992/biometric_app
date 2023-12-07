package com.miaxis.demo.util;

import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;


import java.io.IOException;
public class NtlmAuthenticator implements Authenticator {
    @Override
    public Request authenticate(Route route, Response response) throws IOException {
        // Replace with your NTLM domain, username, and password
        String domain = "your_domain";
        String username = "frontenduser";
        String password = "fuser@123";

        String credentials = Credentials.basic(username, password);

        return response.request().newBuilder()
            .header("Authorization", credentials)
            .build();
    }
}