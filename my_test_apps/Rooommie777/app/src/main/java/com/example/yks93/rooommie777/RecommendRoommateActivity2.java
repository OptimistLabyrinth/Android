package com.example.yks93.rooommie777;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.yks93.rooommie777.signup_actions.SignupOneActivity;
import com.example.yks93.rooommie777.static_storage.StaticVarMethods;
import com.example.yks93.rooommie777.trylogin.LoginPageActivity;
import com.example.yks93.rooommie777.using_mypage_menu.MyPageActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecommendRoommateActivity2 extends AppCompatActivity {

    private final String TAG = "RecommendRoommateActiv2";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend_roommate2);
        ButterKnife.bind(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d(TAG, "onCreateOptionsMenu: ");
        MenuInflater menuInflater = getMenuInflater();
        Long tsLong = System.currentTimeMillis() / 1000;
        int tsNow = Integer.parseInt(tsLong.toString());

        SharedPreferences sp = getSharedPreferences(StaticVarMethods.UserLoginPref, Context.MODE_PRIVATE);
        int tsSaved = Integer.parseInt(sp.getString(StaticVarMethods.LOGIN_TIME, "0"));

        if (sp.getString(StaticVarMethods.USER_ID, "--").equals("--")
                || tsNow - tsSaved > 27494400) {
            sp.edit().remove(StaticVarMethods.USER_ID)
                    .remove(StaticVarMethods.USER_PWD)
                    .remove(StaticVarMethods.LOGIN_TIME)
                    .apply();
            menuInflater.inflate(R.menu.menus_default, menu);
        } else {
            menuInflater.inflate(R.menu.menus_after_login, menu);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(TAG, "onOptionsItemSelected: ");
        switch (item.getItemId())
        {
            case R.id.login_menu:
                onLoginMenuClicked();
                break;


            case R.id.signup_menu:
                onSignupMenuClicked();
                break;


            case R.id.menu_mypage:
                onMypageMenuClicked();
                break;

            case R.id.menu_logout:
                onLogoutMenuClicked();
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

    void onLoginMenuClicked() {
        Intent intent = new Intent(this, LoginPageActivity.class);
        startActivity(intent);
    }
    void onSignupMenuClicked() {
        Intent intent = new Intent(this, SignupOneActivity.class);
        startActivity(intent);

    }
    void onMypageMenuClicked() {
        Intent intent = new Intent(this, MyPageActivity.class);
        startActivity(intent);
    }
    void onLogoutMenuClicked() {
        SharedPreferences.Editor editor = getSharedPreferences(StaticVarMethods.UserLoginPref, Context.MODE_PRIVATE).edit();

        editor.remove(StaticVarMethods.USER_ID)
                .remove(StaticVarMethods.USER_PWD)
                .remove(StaticVarMethods.LOGIN_TIME)
                .apply();

        Intent i = new Intent(this, AfterTheFirstClickActivity.class);
        startActivity(i);
    }

    private void onGotoHomeMenuClicked() {
        Intent i = new Intent(this, AfterTheFirstClickActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.btn_one)
    void onButtonOneClicked() {

    }

//    @OnClick(R.id.btn_two)
//    void onButtonTwoClicked() {
//
//    }
//
//    @OnClick(R.id.btn_three)
//    void onButtonThreeClicked() {
//
//    }
//
//    @OnClick(R.id.btn_four)
//    void onButtonFourClicked() {
//
//    }
//
//    @OnClick(R.id.btn_five)
//    void onButtonFiveClicked() {
//
//    }





}
