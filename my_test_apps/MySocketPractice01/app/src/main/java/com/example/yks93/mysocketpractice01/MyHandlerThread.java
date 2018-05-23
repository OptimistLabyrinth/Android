package com.example.yks93.mysocketpractice01;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import android.widget.Toast;

public class MyHandlerThread extends HandlerThread {

    Context context = null;

    public MyHandlerThread() {
        super("New MyHandleThread");
    }

    public MyHandlerThread(String name) {
        super(name);
    }

    public MyHandlerThread(String name, Context context) {
        super(name);
        this.context = context;
    }

    public MyHandlerThread(String name, int priority) {
        super(name, priority);
    }

    public MyHandlerThread(String name, int priority, Context context) {
        super(name, priority);
        this.context = context;
    }

    /* methods in "HandlerThread" class */
    @Override
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        Toast.makeText(this.context, "Wait For a moment", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void run() {
        super.run();
    }

    @Override
    public Looper getLooper() {
        return super.getLooper();
    }

    @Override
    public int getThreadId() {
        return super.getThreadId();
    }

    @Override
    public boolean quitSafely() {
        return super.quitSafely();
    }



    /* methods in "Thread" class */
    @Override
    public void interrupt() {
        super.interrupt();
    }


}
