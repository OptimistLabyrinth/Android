package com.example.yks93.rooommie777.forgot_info;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.yks93.rooommie777.AfterTheFirstClickActivity;
import com.example.yks93.rooommie777.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgotIDActivity extends AppCompatActivity {

    @BindView(R.id.btn_main_forgotid)
    Button button;

    private final String TAG = "ForgotIDActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_id);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.btn_main_forgotid)
    void onButtonClick() {
        Intent intent = new Intent(this, AfterTheFirstClickActivity.class);
        startActivity(intent);
    }

}
