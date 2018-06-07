package com.example.yks93.myapptest003;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SocketClient {

    private static Retrofit SocketClientInstance = null;
    private static final String BASE_URL = "https://www.naver.com";

    private static final String TAG = "RetrofitClientInstance";

    public static Retrofit getSocketClientInstance() {
        if (SocketClientInstance == null) {
            synchronized (SocketClient.class) {
                if (SocketClientInstance == null) {
                    SocketClientInstance = new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                }
            }
        }
        Log.d(TAG, "getRetrofitInstance: ");

        return SocketClientInstance;
    }

}
