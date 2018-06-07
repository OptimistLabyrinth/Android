package com.example.yks93.rooommie777;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.yks93.rooommie777.searchroommate.RecommendRoommateActivity;
import com.example.yks93.rooommie777.signup_actions.SignupOneActivity;
import com.example.yks93.rooommie777.static_storage.StaticVarMethods;
import com.example.yks93.rooommie777.trylogin.LoginPageActivity;
import com.example.yks93.rooommie777.using_mypage_menu.MyPageActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class AfterTheFirstClickActivity extends AppCompatActivity {

    private final String TAG = "AfterTheFirstClickActiv";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_the_first_click);

        ButterKnife.bind(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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
            menuInflater.inflate(R.menu.menus_home_page, menu);
//            menuInflater.inflate(R.menu.menus_default, menu);
        } else {
            menuInflater.inflate(R.menu.menus_after_login, menu);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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

    @OnClick({R.id.searchRoommateImage, R.id.searchRoommateText})
    void searchRoomateClicked(View v) {
        Intent intent = new Intent(this, RecommendRoommateActivity.class);
        String user_id = getSharedPreferences(StaticVarMethods.UserLoginPref, Context.MODE_PRIVATE)
                .getString(StaticVarMethods.USER_ID, "None");

        if (user_id.equals("None")) {
            new AlertDialog.Builder(this)
                    .setMessage(R.string.login_first_message)
                    .setPositiveButton(R.string.OK_button, (d, i) -> {
                        onLoginMenuClicked();
                    })
                    .create().show();
            return;
        }

//        Intent intent = new Intent(this, RecommendRoommateActivity2.class);
        startActivity(intent);
    }

    @OnClick({R.id.searchHouseImage, R.id.searchHouseText})
    void searchHouseClicked (View v) {
//        Intent intent = new Intent(this, SearchHouseActivity.class);
//        startActivity(intent);
        new AlertDialog.Builder(this)
                .setMessage(R.string.not_ready_yet_service_message)
                .setPositiveButton(R.string.OK_button, (d, i) -> {})
                .create().show();
    }

    @OnClick({R.id.bulletinBoardImage, R.id.bulletinBoardText})
    void bulletinBoardClicked (View v) {
//        Intent intent = new Intent(this, BulletinBoardActivity.class);
//        startActivity(intent);
        new AlertDialog.Builder(this)
                .setMessage(R.string.not_ready_yet_service_message)
                .setPositiveButton(R.string.OK_button, (d, i) -> {})
                .create().show();
    }

    @OnClick({R.id.tipsImage, R.id.tipsText})
    void tipsClicked (View v) {
        Intent intent = new Intent(this, TipsActivity.class);
        startActivity(intent);
    }

    @OnClick({R.id.mypageImage, R.id.mypageText})
    void myPageClicked (View v) {

        String user_id = getSharedPreferences(StaticVarMethods.UserLoginPref, Context.MODE_PRIVATE)
                .getString(StaticVarMethods.USER_ID, "None");

        if (user_id.equals("None")) {
            new AlertDialog.Builder(this)
                    .setMessage(R.string.login_first_message)
                    .setPositiveButton(R.string.OK_button, (d, i) -> {
                        onLoginMenuClicked();
                    })
                    .create().show();
            return;
        }

        Intent intent = new Intent(this, MyPageActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.imageview_fortune_cookie)
    void onFortuneCookieClicked() {
        Intent intent = new Intent(this, FortuneCookieActivity.class);
        startActivity(intent);
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

    void onGotoHomeMenuClicked() {
        Intent i = new Intent(this, AfterTheFirstClickActivity.class);
        startActivity(i);
    }

}
