package com.example.yks93.mysocketpractice01;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class MyClientService extends IntentService {

    public Context theContext = null;

    public MyClientService() {
        super("Client Socket IntentService");
    }

    public MyClientService(String name) {
        super(name);
    }

    MyClientService(Context theContext) {
        super("Client Socket IntentService");
        this.theContext = theContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public void onStart(@Nullable Intent intent, int startId) {
        super.onStart(intent, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override
    public void setIntentRedelivery(boolean enabled) {
        super.setIntentRedelivery(enabled);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {



    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
