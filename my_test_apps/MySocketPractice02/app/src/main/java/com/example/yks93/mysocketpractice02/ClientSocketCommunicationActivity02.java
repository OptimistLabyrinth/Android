package com.example.yks93.mysocketpractice02;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClientSocketCommunicationActivity02 extends AppCompatActivity {

    @BindView(R.id.socket_balance_value)
    TextView tv_socket_balance;
    @BindView(R.id.btn_socket_deposit)
    Button btn_socket_deposit;
    @BindView(R.id.btn_socket_withdraw)
    Button btn_socket_withdraw;
    @BindView(R.id.et_amount)
    EditText et_socket_amount;
    @BindView(R.id.textview_testsss)
    TextView tv_testsss;
    @BindView(R.id.btn_move_to_synchronous_thread)
    Button btn_move_to_sync;

    String resultBalanceData = "";
    private final String TAG = "ClientSocketCommu";

    int onResponseReturned = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_socket_communication);

        ButterKnife.bind(this);
//        socket_spinner.setVisibility(View.GONE);
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

    private void onProcessButtonClicked(String which) {
        Log.d(TAG, "onProcessButtonClicked: ");

        String balance = tv_socket_balance.getText().toString();
        String amount = et_socket_amount.getText().toString();
        String depositOrWithdraw = which;

        GetResultService service = RetrofitClientInstance.getRetrofitInstance().create(GetResultService.class);
        Log.d(TAG, "onProcessButtonClicked: RetrofitInstance.create()");
        Call<List<RetroNumberData>> call = service.getBalanceResult(balance, amount, depositOrWithdraw);
        Log.d(TAG, "onProcessButtonClicked: service.getBalanceResult()");

        call.enqueue(new Callback<List<RetroNumberData>>() {
            @Override
            public void onResponse(Call<List<RetroNumberData>> call, Response<List<RetroNumberData>> response) {
                Log.d(TAG, "onResponse: started");
//                String resultBalanceData = response.body().get(0).getBalance();
                Response<List<RetroNumberData>> a = response;
                Log.d(TAG, "onResponse: a = response " + a.toString());

                List<RetroNumberData> b = a.body();
                Log.d(TAG, "onResponse: b = a.body() " + b.toString());

                RetroNumberData c = b.get(0);
                Log.d(TAG, "onResponse: RetroNumberData c = b.get(0) " + c.toString());

                String d = c.getBalance();
                Log.d(TAG, "onResponse: d = c.getBalance() " + d);

                resultBalanceData = d;
                Log.d(TAG, "onResponse: resultBalanceData = d " + resultBalanceData);

                tv_socket_balance.setText(resultBalanceData);
                Log.d(TAG, "onProcessButtonClicked: setText");

//                socket_spinner.setVisibility(View.GONE);
                Log.d(TAG, "onResponse: finished");

                onResponseReturned = 1;
                Log.d(TAG, "onResponse: onResponseReturned Value changed to " + onResponseReturned);
            }

            @Override
            public void onFailure(Call<List<RetroNumberData>> call, Throwable t) {
                t.printStackTrace();
                Log.d(TAG, "onFailure: ");

                return;
            }
        });

        Log.d(TAG, "onProcessButtonClicked: value of onResponseReturned = " + onResponseReturned);

        String msg = tv_testsss.getText().toString() + " " + onResponseReturned;
        Log.d(TAG, "onProcessButtonClicked: msg = " + msg);
        tv_testsss.setText(msg);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Nice! It's working :)")
                .setPositiveButton("close", (d, w) -> { ; });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @OnClick(R.id.btn_socket_deposit)
    void onDepositButtonClicked() {
//        socket_spinner.setVisibility(View.VISIBLE);
        onProcessButtonClicked("deposit");    // 0 means deposit action
    }

    @OnClick(R.id.btn_socket_withdraw)
    void onWithdrawButtonClicked() {
//        socket_spinner.setVisibility(View.VISIBLE);
        onProcessButtonClicked("withdraw");    // 1 means withdraw action
    }

    @OnClick(R.id.btn_move_to_synchronous_thread)
    void onGoToNextButtonClicked() {
        Intent intent = new Intent(this, ClientSyncRetrofit02.class);
        startActivity(intent);
    }


}
