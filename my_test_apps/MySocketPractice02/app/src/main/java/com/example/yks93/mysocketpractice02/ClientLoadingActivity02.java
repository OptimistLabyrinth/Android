package com.example.yks93.mysocketpractice02;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClientLoadingActivity02 extends AppCompatActivity {

    Intent intent;
    int value = 0;

    private final String TAG = "ClientLoadingActivity02";
    public final int REQUEST_DEPOSIT = 1;
    public final int REQUEST_WITHDRAW = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_loading02);

        ButterKnife.bind(this);

        intent = getIntent();

        Log.d(TAG, "onCreate: ");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d(TAG, "onCreateOptionsMenu: ");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(TAG, "onOptionsItemSelected: ");
        return super.onOptionsItemSelected(item);
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

        value = Integer.parseInt(intent.getStringExtra("balance"));
        int modifyValue = intent.getIntExtra("deposit_withdraw", 0);
        int requstCode = intent.getIntExtra("requstcode", -1);

        if (requstCode == REQUEST_DEPOSIT) {
            value += modifyValue;
            Log.d(TAG, "onResume: REQUEST_DEPOSIT");
        }
        else if (requstCode == REQUEST_WITHDRAW) {
            value -= modifyValue;
            Log.d(TAG, "onResume: REQUEST_WITHDRAW");
        }

        intent.putExtra("Result", String.valueOf(value));
        setResult(RESULT_OK, intent);

        finish();
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
    
    private void onProcessDepositClicked() {

    }

    private void onProcessWithdrawClicked() {

    }



    /*
     *  Used only for tests
     *
     *  Deprecated
     */
    private class SpendTwoSeconds extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Log.d(TAG, "doInBackground: caught InterruptedException");
            }

            return null;
        }
    }

}
