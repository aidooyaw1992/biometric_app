package com.miaxis.demo.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.miaxis.demo.data.remote.response.Agent;

public class MySharedPreferences {

    private static final String PREF_NAME = "MyPreferences";
    private static final String KEY_USER = "user";

    // Save the user in SharedPreferences
    public static void saveUser(Context context, Agent user) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_USER, user.toJson());
        editor.apply();
    }

    // Retrieve the user from SharedPreferences
    public static Agent getUser(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        String json = preferences.getString(KEY_USER, null);

        if (json != null) {
            // Convert JSON string back to User object
            return new Gson().fromJson(json, Agent.class);
        } else {
            return null;
        }
    }
}