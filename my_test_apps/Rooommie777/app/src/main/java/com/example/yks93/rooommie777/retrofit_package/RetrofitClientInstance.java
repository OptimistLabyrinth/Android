package com.example.yks93.rooommie777.retrofit_package;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    private static Retrofit retrofitInstance = null;
    private static final String BASE_URL = "http://172.20.10.6:8000";

    private static final String TAG = "RetrofitClientInstance";

    public static Retrofit getRetrofitInstance() {
        if (retrofitInstance == null) {
            synchronized (RetrofitClientInstance.class) {
                if (retrofitInstance == null) {
                    retrofitInstance = new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                }
            }
        }
        Log.d(TAG, "getRetrofitInstance: ");

        return retrofitInstance;
    }

}
