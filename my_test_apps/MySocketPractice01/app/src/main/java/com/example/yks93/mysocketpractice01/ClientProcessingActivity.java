package com.example.yks93.mysocketpractice01;

import android.app.Activity;
import android.os.Bundle;
import android.os.Process;
import android.support.annotation.Nullable;

public class ClientProcessingActivity extends Activity {

    private MyHandlerThread send_thread = null;
    private MyHandlerThread recv_thread = null;
    private MyHandler send_handler = null;
    private MyHandler recv_handler = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.send_thread = new MyHandlerThread("Client Sender Thread",
                Process.THREAD_PRIORITY_BACKGROUND);
        this.recv_thread = new MyHandlerThread("Client Receiver Thread",
                Process.THREAD_PRIORITY_BACKGROUND);

//        Message msg = this.send_handler.obtainMessage();
//        msg.obj = "Message String";
//        this.send_handler.sendMessage(msg);
    }

    @Override
    protected void onStart() {
        super.onStart();
        send_thread.start();
        recv_thread.start();
        this.send_handler = new MyHandler(send_thread.getLooper(), this, this.msgList);
        this.recv_handler = new MyHandler(recv_thread.getLooper(), this, this.msgList);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        send_thread.quitSafely();
        recv_thread.quitSafely();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }



}
