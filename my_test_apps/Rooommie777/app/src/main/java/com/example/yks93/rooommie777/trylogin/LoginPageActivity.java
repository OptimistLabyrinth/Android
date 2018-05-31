package com.example.yks93.rooommie777.trylogin;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.yks93.rooommie777.AfterTheFirstClickActivity;
import com.example.yks93.rooommie777.R;
import com.example.yks93.rooommie777.retrofit_package.RetrofitClientInstance;
import com.example.yks93.rooommie777.signup_actions.SignupOneActivity;
import com.example.yks93.rooommie777.static_storage.StaticVarMethods;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPageActivity extends AppCompatActivity {

    @BindView(R.id.editText_id)
    EditText et_id;
    @BindView(R.id.editText_password)
    EditText et_pwd;
    @BindView(R.id.btn_login)
    Button btn_login;
    @BindView(R.id.btn_signup)
    Button btn_signup;

    private final String TAG = "LoginPageActivity";
    public int tryNetworkCount = 10;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        ButterKnife.bind(this);

        Log.d(TAG, "onCreate: ");
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

    @OnClick(R.id.btn_login)
    void loginButtonClicked (View v) {
        TryLoginThread tryLoginThread = new TryLoginThread("try_login");
        tryLoginThread.start();
        Handler handler = new Handler(tryLoginThread.getLooper());
        handler.post(tryLoginThread);

        if (tryNetworkCount <= 0) {
            tryLoginThread.quitSafely();
            onTryLoginFailed();
        } else {
            tryLoginThread.quitSafely();

            SharedPreferences.Editor editor = getSharedPreferences(StaticVarMethods.UserLoginPref, Context.MODE_PRIVATE).edit();
            Long tsLong = System.currentTimeMillis() / 1000;

            editor.putString(StaticVarMethods.USER_ID, et_id.getText().toString())
                    .putString(StaticVarMethods.USER_PWD, et_pwd.getText().toString())
                    .putString(StaticVarMethods.LOGIN_TIME, tsLong.toString())
                    .apply();

            Intent intent = new Intent(this, AfterTheFirstClickActivity.class);
            startActivity(intent);
        }

    }

    @OnClick(R.id.btn_signup)
    void signupButtonClicked (View v) {
        Intent intent = new Intent(this, SignupOneActivity.class);
        startActivity(intent);
    }

    @OnClick({R.id.naver_login, R.id.daum_login, R.id.google_login, R.id.facebook_login})
    void onOAuth2LoginButtonClicked() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setMessage(R.string.not_ready_yet_message)
                .setPositiveButton(R.string.OK_button, (d, i) -> {});
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void onTryLoginFailed() {
        tryNetworkCount = 10;
        alertOnTryLoginFailed();
    }

    private void alertOnTryLoginFailed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setMessage(R.string.login_failed_message)
                .setPositiveButton(R.string.OK_button, (d, i) -> {});
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public class TryLoginThread extends HandlerThread {

        private final String TAG = "TryLoginThread";

        private boolean tryLoginSuccess = false;

        public TryLoginThread(String name) {
            super(name);
        }

        public TryLoginThread(String name, int priority) {
            super(name, priority);
        }

        public void setTryLoginSuccess(boolean tryLoginSuccess) {
            this.tryLoginSuccess = tryLoginSuccess;
        }

        @Override
        public void run() {
            super.run();

            TryLoginService service = RetrofitClientInstance.getRetrofitInstance().create(TryLoginService.class);
            Call<List<LoginData>> call = service.tryLoginNow(
                    
            );

        }

    }

}
