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
import android.widget.Toast;

import com.example.yks93.mysharedpreferences01.staticClass.StaticStorage;

public class MyPageActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_after_login, menu);

//        return super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_mypage:
                onMenuMypageClicked();
                return true;

            case R.id.menu_logout:
                onMenuLogoutClicked();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void onMenuMypageClicked() {
        Toast.makeText(this, "You're already in My Page", Toast.LENGTH_SHORT).show();
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
