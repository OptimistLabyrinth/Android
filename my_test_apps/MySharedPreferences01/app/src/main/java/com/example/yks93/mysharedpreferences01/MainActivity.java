package com.example.yks93.mysharedpreferences01;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.yks93.mysharedpreferences01.staticClass.StaticStorage;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.tv_login_page);
        textView.setOnClickListener(v -> {
            Intent i = new Intent(this, FirstPageActivity.class);
            startActivity(i);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        Long tsLong = System.currentTimeMillis() / 1000;
        int tsNow = Integer.parseInt(tsLong.toString());

        SharedPreferences sp = getSharedPreferences(StaticStorage.LoginInfo, Context.MODE_PRIVATE);
        int tsSaved = Integer.parseInt(sp.getString(StaticStorage.TIMESTAMP, "0"));

        if (sp.getString(StaticStorage.USER_ID, "--").equals("--")
                || tsNow - tsSaved > 27494400) {
            sp.edit().remove(StaticStorage.USER_ID)
                    .remove(StaticStorage.USER_PWD)
                    .remove(StaticStorage.TIMESTAMP)
                    .apply();
            menuInflater.inflate(R.menu.menu_default, menu);
        } else {
            menuInflater.inflate(R.menu.menu_after_login, menu);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menu_login:
                onMenuLoginClicked();
                return true;

            case R.id.menu_signup:
                onMenuSignupClicked();
                return true;

            case R.id.menu_mypage:
                onMenuMypageClicked();
                return true;

            case R.id.menu_logout:
                onMenuLogoutClicked();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

        //        return super.onOptionsItemSelected(item);
    }

    private void onMenuLoginClicked() {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }

    private void onMenuSignupClicked() {
        Intent i = new Intent(this, SignupActivity.class);
        startActivity(i);
    }

    private void onMenuMypageClicked() {
        Intent i = new Intent(this, MyPageActivity.class);
        startActivity(i);
    }

    private void onMenuLogoutClicked() {
        SharedPreferences.Editor editor = getSharedPreferences(StaticStorage.LoginInfo, Context.MODE_PRIVATE).edit();

        editor.remove(StaticStorage.USER_ID)
                .remove(StaticStorage.USER_PWD)
                .remove(StaticStorage.TIMESTAMP)
                .apply();

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

}
