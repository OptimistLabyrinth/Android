package com.example.yks93.myapptest003;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.response_here)
    TextView textView;

    DataClass responseMessage = null;

    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.response_here)
    void onClicked() {

        GetHttpResponse service = SocketClient.getSocketClientInstance().create(GetHttpResponse.class);
        Call<DataClass> call = service.onResponse();

        call.enqueue(new Callback<DataClass>() {
            @Override
            public void onResponse(Call<DataClass> call, Response<DataClass> response) {
                Log.d(TAG, "onResponse: ");
                responseMessage = response.body();
            }

            @Override
            public void onFailure(Call<DataClass> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
            }

        });

        textView.setText(responseMessage.getMessage());

    }


}
