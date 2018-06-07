package com.example.yks93.rooommie777.trylogin;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.yks93.rooommie777.AfterTheFirstClickActivity;
import com.example.yks93.rooommie777.R;
import com.example.yks93.rooommie777.forgot_info.ForgotIDActivity;
import com.example.yks93.rooommie777.forgot_info.ForgotPWDActivity;
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
import retrofit2.Retrofit;

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
    public boolean tryNetworkSuccess = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        ButterKnife.bind(this);

        Log.d(TAG, "onCreate: ");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menus_in_login_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menu_forgot_id:
                onForgotIDClicked();
                break;

            case R.id.menu_forgot_pwd:
                onForgotPWDClicked();
                break;

            case R.id.menu_home_page_in_default:
            case R.id.menu_home_page_in_after_login:
            case R.id.menu_home_page_in_login_page:
            case R.id.menu_home_page_in_home_only:
                onGotoHomeMenuClicked();
                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
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

    private void onForgotIDClicked() {
        Intent i = new Intent(this, ForgotIDActivity.class);
        startActivity(i);
    }

    private void onForgotPWDClicked() {
        Intent i = new Intent(this, ForgotPWDActivity.class);
        startActivity(i);
    }

    void onGotoHomeMenuClicked() {
        Intent i = new Intent(this, AfterTheFirstClickActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.btn_login)
    void loginButtonClicked (View v) {

        checkLoginSuccessFailure();

        if (tryNetworkSuccess == false) {
            onTryLoginFailed();
            return;
        }

        SharedPreferences.Editor editor = getSharedPreferences(StaticVarMethods.UserLoginPref, Context.MODE_PRIVATE).edit();
        Long tsLong = System.currentTimeMillis() / 1000;

        editor.putString(StaticVarMethods.USER_ID, et_id.getText().toString())
                .putString(StaticVarMethods.USER_PWD, et_pwd.getText().toString())
                .putString(StaticVarMethods.LOGIN_TIME, tsLong.toString())
                .apply();

        Intent intent = new Intent(this, AfterTheFirstClickActivity.class);
        startActivity(intent);

    }

    @OnClick(R.id.btn_signup)
    void signupButtonClicked (View v) {
        Intent intent = new Intent(this, SignupOneActivity.class);
        startActivity(intent);
    }

    @OnClick({R.id.naver_login, R.id.daum_login, R.id.google_login, R.id.facebook_login})
    void onOAuth2LoginButtonClicked() {
        new AlertDialog.Builder(this)
                .setMessage(R.string.not_ready_yet_message)
                .setPositiveButton(R.string.OK_button, (d, i) -> {})
                .create().show();
    }

    public void setTryNetworkSuccess(boolean b) {
        this.tryNetworkSuccess = b;
    }

    private void onTryLoginFailed() {
        new AlertDialog.Builder(this)
                .setMessage(R.string.login_failed_message)
                .setPositiveButton(R.string.OK_button, (d,i) -> {})
                .create().show();
    }

    private void checkLoginSuccessFailure() {
        TryLoginService service = RetrofitClientInstance.getRetrofitInstance().create(TryLoginService.class);
        Call<List<LoginData>> call = service.tryLoginNow(
                et_id.getText().toString(),
                et_pwd.getText().toString()
        );

        call.enqueue(new TryLoginCallback());

    }

    private class TryLoginCallback implements Callback<List<LoginData>> {

        private final String TAG = "TryLoginCallback";

        @Override
        public void onResponse(Call<List<LoginData>> call, Response<List<LoginData>> response) {
            int code = response.code();
            Log.d(TAG, "onResponse: code = " + code);

            setTryNetworkSuccess(true);
        }

        @Override
        public void onFailure(Call<List<LoginData>> call, Throwable t) {
            Log.d(TAG, "onFailure: " + t.toString());

//            onTryLoginFailed();
        }
    }

}
