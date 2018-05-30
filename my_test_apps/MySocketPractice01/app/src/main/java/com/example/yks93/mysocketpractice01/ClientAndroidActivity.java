package com.example.yks93.mysocketpractice01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ClientAndroidActivity extends Activity {

    @BindView(R.id.balance_value)
    TextView balanceTV = null;

    ArrayList msgList = new ArrayList<String>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_android);

        ButterKnife.bind(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
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
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @SuppressWarnings("unchecked")
    @OnClick(R.id.btn_deposit)
    void onBtnDepositClicked(View v) {
        Message msg = this.send_handler.obtainMessage();
        msgList.clear();
        msgList.add(this.balanceTV.getText().toString());
        msgList.add("\n");
        msgList.add("10");
        msg.obj = msgList;
        this.send_handler.sendMessage(msg);
    }

    @SuppressWarnings("unchecked")
    @OnClick(R.id.btn_withdraw)
    void onBtnWithdrawClicked(View v) {
        Message msg = this.send_handler.obtainMessage();
        msgList.clear();
        msgList.add(this.balanceTV.getText().toString());
        msgList.add("\n");
        msgList.add("-10");
        msg.obj = msgList;
        this.send_handler.sendMessage(msg);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
