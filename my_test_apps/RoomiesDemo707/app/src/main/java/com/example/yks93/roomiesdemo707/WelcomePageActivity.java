package com.example.yks93.roomiesdemo707;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class WelcomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.activity_welcome_page)
    void welcomePageClicked(View v) {
        Intent intent = new Intent(this, AfterTheFirstClickActivity.class);
        startActivity(intent);
    }

}
