package com.example.yks93.mysharedpreferences01;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yks93.mysharedpreferences01.staticClass.StaticStorage;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.editText1)
    EditText et_id;
    @BindView(R.id.editText2)
    EditText et_pwd;
    @BindView(R.id.btn_login)
    Button btn_login;

    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_default, menu);
        return true;

        //        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menu_login:
                onMenuLoginClickedinLoginPage();
                return true;

            case R.id.menu_signup:
                onMenuSignupClicked();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

        //        return super.onOptionsItemSelected(item);
    }

    private void onMenuLoginClickedinLoginPage() {
        Toast.makeText(this, "You're already in Login Page", Toast.LENGTH_SHORT).show();
    }

    private void onMenuSignupClicked() {
        Intent i = new Intent(this, SignupActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.btn_login)
    void onLoginButtonClicked() {
        SharedPreferences.Editor editor = getSharedPreferences(StaticStorage.LoginInfo, Context.MODE_PRIVATE).edit();

        String id_value = et_id.getText().toString();
        String pwd_value = et_pwd.getText().toString();
        Long tsLong = System.currentTimeMillis() / 1000;
        String ts = tsLong.toString();

        editor.putString(StaticStorage.USER_ID, id_value);
        editor.putString(StaticStorage.USER_PWD, id_value);
        editor.putString(StaticStorage.TIMESTAMP, ts);
        editor.commit();

        Intent loginIntent = new Intent(this, AfterLoginActivity.class);
        startActivity(loginIntent);
    }


}
