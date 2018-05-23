package com.example.yks93.mysocketpractice01;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class MyHandler extends Handler {

    Activity activity = null;
    ArrayList<String> sendMsgList = null;
    String result = null;

    private Socket socket = null;
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 80;
    private boolean tcpSendSucceeded = true;
    private boolean tcpReceiveSucceeded = true;

    public MyHandler() {
        super();
    }

    public MyHandler(Activity activity) {
        super();
        this.activity = activity;
    }

    public MyHandler(Looper looper) {
        super(looper);
    }

    public MyHandler(Looper looper, Activity activity) {
        super(looper);
        this.activity = activity;
    }
    public MyHandler(Looper looper, Activity activity, ArrayList arrayList) {
        super(looper);
        this.activity = activity;
        this.sendMsgList = arrayList;
    }

    public MyHandler(Callback callback) {
        super(callback);
    }

    public MyHandler(Looper looper, Callback callback) {
        super(looper, callback);
    }

    public MyHandler(Looper looper, Callback callback, Activity activity) {
        super(looper, callback);
        this.activity = activity;
    }

    @Override
    public void handleMessage(Message msg) {
        boolean tcpSendResult = sendTCPRequest();

        if (tcpSendResult != true)
                Log.e("Send.handleMessage", "FAILURE : sendTCPRequest");
        else
                Log.d("Send.handleMessage", "SUCCESS : send tcp request");



        boolean tcpReceiveResult = receiveTCPResponse();

        if (tcpReceiveResult != true)
            Log.e("Receive.handleMessage", "FAILURE : receiveTCPRequest");
        else
            Log.d("Receive.handleMessage", "SUCCESS : receive tcp request");
    }

    @Override
    public String getMessageName(Message message) {
        return super.getMessageName(message);
    }

    @Override
    public boolean sendMessageAtTime(Message msg, long uptimeMillis) {
        return super.sendMessageAtTime(msg, uptimeMillis);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    private boolean sendTCPRequest() {

        Writer writer = null;

        try {

            socket = new Socket(SERVER_IP, SERVER_PORT);

            writer = new BufferedWriter(
                            new OutputStreamWriter(socket.getOutputStream()));

            for (String s : this.sendMsgList) {
                writer.write(s);
            }

        } catch (SocketException e) {
            e.printStackTrace();
            tcpSendSucceeded = false;
            Log.e("Send.handleMessage", "SocketException occurred");
        } catch (UnknownHostException e){
            e.printStackTrace();
            tcpSendSucceeded = false;
            Log.e("Send.handleMessage", "UnknownHostException occurred");
        } catch (IOException e) {
            e.printStackTrace();
            tcpSendSucceeded = false;
            Log.e("Send.handleMessage", "IOException occurred");
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    tcpSendSucceeded = false;
                    Log.e("Send.handleMessage", "(finally) closing a socket failed");
                }
            }
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    tcpSendSucceeded = false;
                    Log.e("Send.handleMessage", "(finally) closing a writer failed");
                }
            }
        }
        return tcpSendSucceeded;
    }

    private boolean receiveTCPResponse() {

        Reader reader = null;

        try {

            reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));



        } catch (SocketException e) {
            e.printStackTrace();
            tcpReceiveSucceeded = false;
            Log.e("Receive.handleMessage", "SocketException occurred");
        } catch (UnknownHostException e){
            e.printStackTrace();
            tcpReceiveSucceeded = false;
            Log.e("Receive.handleMessage", "UnknownHostException occurred");
        } catch (IOException e) {
            e.printStackTrace();
            tcpReceiveSucceeded = false;
            Log.e("Receive.handleMessage", "IOException occurred");
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    tcpReceiveSucceeded = false;
                    Log.e("Receive.handleMessage", "(finally) closing a socket failed");
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    tcpReceiveSucceeded = false;
                    Log.e("Receive.handleMessage", "(finally) closing a reader failed");
                }
            }
        }
        return tcpReceiveSucceeded;
    }

}
