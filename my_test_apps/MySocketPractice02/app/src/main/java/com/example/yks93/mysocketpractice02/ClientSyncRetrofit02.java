package com.example.yks93.mysocketpractice02;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ClientSyncRetrofit02 extends AppCompatActivity {

    @BindView(R.id.sync_balance_value)
    TextView tv_sync_balance;
    @BindView(R.id.sync_amount)
    EditText et_sync_amount;
    @BindView(R.id.btn_sync_deposit)
    Button btn_sync_deposit;
    @BindView(R.id.btn_sync_withdraw)
    Button btn_sync_withdraw;

    private final String TAG="ClientSyncRetrofit02";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_sync_retrofit02);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @OnClick(R.id.btn_sync_deposit)
    void onSyncDepositClicked() {
        Log.d(TAG, "onSyncDepositClicked: ");
    }

    @OnClick(R.id.btn_sync_withdraw)
    void onSyncWithdrawClicked() {
        Log.d(TAG, "onSyncWithdrawClicked: ");

    }

}
