package com.example.yks93.mysocketpractice02;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ClientActivity02 extends AppCompatActivity {

    @BindView(R.id.btn_socket_activity)
    Button btnSocketComm;
    @BindView(R.id.balance_value)
    TextView tvBalance;
    @BindView(R.id.btn_deposit)
    Button btnDeposit;
    @BindView(R.id.btn_withdraw)
    Button btnWithdraw;
    @Nullable
    @BindView(R.id.progressBar_main)
    ProgressBar spinner;

    Intent intent = null;

    private String result = "50";

    private final String TAG = "ClientActivity02";
    public final int REQUEST_DEPOSIT = 1;
    public final int REQUEST_WITHDRAW = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client02);

        ButterKnife.bind(this);
        spinner.setVisibility(View.GONE);
        Log.d(TAG, "onCreate: view-binding finished");


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

        tvBalance.setText(result);
        intent = new Intent(this, ClientLoadingActivity02.class);
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

    @OnClick(R.id.btn_socket_activity)
    void onSocketCommunicationButtonClicked() {
        Log.d(TAG, "onSocketCommunicationButtonClicked: ");

        Intent intent = new Intent(this, ClientSocketCommunicationActivity02.class);
        startActivity(intent);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
    }

    @OnClick(R.id.btn_deposit)
    void onDepositButtonClicked() {
        Log.d(TAG, "onDepositButtonClicked: ");
        spinner.setVisibility(View.VISIBLE);

        if (intent != null)
            intent = new Intent(ClientActivity02.this, ClientLoadingActivity02.class);
        String tvBalanceValue = tvBalance.getText().toString();
        intent.putExtra("balance", tvBalanceValue);
        intent.putExtra("deposit_withdraw", 10);
        intent.putExtra("requstcode", REQUEST_DEPOSIT);
        startActivityForResult(intent, REQUEST_DEPOSIT);
    }

    @OnClick(R.id.btn_withdraw)
    void onWithdrawButtonClicked() {
        Log.d(TAG, "onWithdrawButtonClicked: ");
        spinner.setVisibility(View.VISIBLE);

        if (intent != null)
            intent = new Intent(ClientActivity02.this, ClientLoadingActivity02.class);
        intent.putExtra("balance", tvBalance.getText().toString());
        intent.putExtra("deposit_withdraw", 10);
        intent.putExtra("requstcode", REQUEST_WITHDRAW);
        startActivityForResult(intent, REQUEST_WITHDRAW);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "onActivityResult: ");
        super.onActivityResult(requestCode, resultCode, data);
        spinner.setVisibility(View.GONE);

        if (resultCode == RESULT_OK) {
            result = data.getStringExtra("Result");
            tvBalance.setText(result);

            if (requestCode == REQUEST_DEPOSIT)
                Toast.makeText(ClientActivity02.this, "Task(Deposit) Complete", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(ClientActivity02.this, "Task(Withdraw) Complete", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(ClientActivity02.this, "Operaction Failed", Toast.LENGTH_SHORT).show();
        }

        intent = null;
    }



    /*
     *  Used only for test
     *
     *  Deprecated Class
     */
    private class WaitingTask extends AsyncTask<ArrayList<String>, String, Integer> {

        @Override
        protected Integer doInBackground(ArrayList<String>... arrayLists) {
            int i = 0;
            int index = 0;
            int result = 0;

            ArrayList<String> list = arrayLists[0];
            int[] temp = new int[list.size()];
            for (String s : list) {
                temp[index] = Integer.parseInt(list.get(index));
                result += temp[index];
                ++index;
            }

            while (i < 3) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ++i;
            }
            return new Integer(result);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Integer i) {
            super.onPostExecute(i);
            tvBalance.setText(String.valueOf(i.intValue()));
        }
    }

}
