package com.example.yks93.roomiedemo717;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.yks93.roomiedemo717.signup_actions.SignupOneActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginMenuActivity extends AppCompatActivity{

    @BindView(R.id.btn_login)
    Button loginB = null;
    @BindView(R.id.btn_signup)
    Button signupB = null;

    private final String TAG = "LoginMenuActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_menu);
        ButterKnife.bind(this);

        Log.d("LoginMenuActivity", "");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LoginMenuActivity", "");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LoginMenuActivity", "");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LoginMenuActivity", "");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LoginMenuActivity", "");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LoginMenuActivity", "");
    }

    @OnClick(R.id.btn_login)
    void loginButtonClicked (View v) {

    }

    @OnClick(R.id.btn_signup)
    void signupButtonClicked (View v) {
        Intent intent = new Intent(this, SignupOneActivity.class);
        startActivity(intent);
    }


    // Private Class for Socket Network Communication
    private class HandleLoginAction extends IntentService {

        public HandleLoginAction() {
            super("private class for Socket Network Communication");
        }

        @Override
        protected void onHandleIntent(@Nullable Intent workIntent) {

        }
    }

}
