package com.example.yks93.rooommie777;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import butterknife.ButterKnife;

public class AfterSignupFinishActivity extends AppCompatActivity {

    private final String TAG = "AfterSignupFinishActivi";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_signup_finish);
        ButterKnife.bind(this);


    }

}
