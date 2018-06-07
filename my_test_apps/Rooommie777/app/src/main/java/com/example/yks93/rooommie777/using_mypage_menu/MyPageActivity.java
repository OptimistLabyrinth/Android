package com.example.yks93.rooommie777.using_mypage_menu;

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
import android.widget.Toast;

import com.example.yks93.rooommie777.AfterTheFirstClickActivity;
import com.example.yks93.rooommie777.R;
import com.example.yks93.rooommie777.RecommendRoommateActivity2;
import com.example.yks93.rooommie777.retrofit_package.RetrofitClientInstance;
import com.example.yks93.rooommie777.searchroommate.RecommendRoommateActivity;
import com.example.yks93.rooommie777.signup_actions.SignupOneActivity;
import com.example.yks93.rooommie777.static_storage.StaticVarMethods;
import com.example.yks93.rooommie777.trylogin.LoginPageActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyPageActivity extends AppCompatActivity {

    private DataforMypage dataBundle = null;

    private final String TAG = "MyPageActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menus_mypage, menu);

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
            case R.id.logout_in_mypage:
                onLogoutMenuClicked();
                break;

            case R.id.menu_go_to_search_roommate:
                onGotoSearchRoommateClicked();
                break;

            case R.id.menu_home_page_in_default:
            case R.id.menu_home_page_in_after_login:
            case R.id.menu_home_page_in_login_page:
            case R.id.menu_home_page_in_home_only:
            case R.id.menu_home_in_mypage:
                onGotoHomeMenuClicked();
                break;

            case R.id.menu_record_of_myself:
            case R.id.menu_change_pwd:
                onNotYetReadyServiceClicked();
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

//        executePullUserData();
        String stud_id = getSharedPreferences(StaticVarMethods.UserLoginPref, Context.MODE_PRIVATE)
                .getString(StaticVarMethods.USER_ID, "0");


        PullUserDataService service = RetrofitClientInstance.getRetrofitInstance().create(PullUserDataService.class);
        Call<List<DataforMypage>> call = service.pullUserData(
                "201304346", "2", "3", "4", "5",
                "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20",
                "21", "22", "23", "24"
        );

        call.enqueue(new Callback<List<DataforMypage>>() {
            @Override
            public void onResponse(Call<List<DataforMypage>> call, Response<List<DataforMypage>> response) {
                int code = response.code();
                Log.d(TAG, "onResponse: code = " + code);

                if (code == 200) {
                    setDataBundle(response.body().get(0));

                    Log.d(TAG, "drawMypage: name = " + dataBundle.getName());
                    Log.d(TAG, "drawMypage: name = " + dataBundle.getGender());
                    Log.d(TAG, "drawMypage: name = " + dataBundle.getPhone());
                    Log.d(TAG, "drawMypage: name = " + dataBundle.getEmail());
                    Log.d(TAG, "drawMypage: name = " + dataBundle.getMajor());
                }
                else {
                    this.onFailure(call, new Throwable());
                }
            }

            @Override
            public void onFailure(Call<List<DataforMypage>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.toString());
            }
        });

//        Log.d(TAG, "drawMypage: name = " + dataBundle.getName());
//        Log.d(TAG, "drawMypage: name = " + dataBundle.getGender());
//        Log.d(TAG, "drawMypage: name = " + dataBundle.getPhone());
//        Log.d(TAG, "drawMypage: name = " + dataBundle.getEmail());
//        Log.d(TAG, "drawMypage: name = " + dataBundle.getMajor());
//        Log.d(TAG, "onResume: dataBundle " + dataBundle.toString());

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

    public void setDataBundle(DataforMypage dataBundle) {
        this.dataBundle = dataBundle;
    }

    private void executePullUserData() {
//        PullUserDataService service = RetrofitClientInstance.getRetrofitInstance().create(PullUserDataService.class);
//        Call<List<DataforMypage>> call = service.pullUserData(
//                "201304346", "2", "3", "4", "5",
//                "6", "7", "8", "9", "10",
//                "11", "12", "13", "14", "15",
//                "16", "17", "18", "19", "20",
//                "21", "22", "23", "24"
//        );
//
//        call.enqueue(new MypageCallBack());
//
//        Log.d(TAG, "drawMypage: name = " + dataBundle.getName());
//        Log.d(TAG, "drawMypage: name = " + dataBundle.getGender());
//        Log.d(TAG, "drawMypage: name = " + dataBundle.getPhone());
//        Log.d(TAG, "drawMypage: name = " + dataBundle.getEmail());
//        Log.d(TAG, "drawMypage: name = " + dataBundle.getMajor());

//        doBackgroundTask(call);

    }

//    private void doBackgroundTask(Call<List<DataforMypage>> call) {
//        call.enqueue(new MypageCallBack());
//
//        drawMypage();
//    }

    private void drawMypage() {



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
    void onGotoSearchRoommateClicked() {
        Intent intent = new Intent(this, RecommendRoommateActivity.class);
//        Intent intent = new Intent(this, RecommendRoommateActivity2.class);
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

    void onNotYetReadyServiceClicked() {
        new AlertDialog.Builder(this)
                .setMessage(R.string.not_ready_yet_service_message)
                .setPositiveButton(R.string.OK_button, (d,i) -> {})
                .create().show();
    }

    public class MypageCallBack implements Callback<List<DataforMypage>> {

        @Override
        public void onResponse(Call<List<DataforMypage>> call, Response<List<DataforMypage>> response) {
            Log.d(TAG, "onResponse: code = " + response.code());

            setDataBundle(response.body().get(0));

//            Log.d(TAG, "drawMypage: name = " + dataBundle.getName());
//            Log.d(TAG, "drawMypage: name = " + dataBundle.getGender());
//            Log.d(TAG, "drawMypage: name = " + dataBundle.getPhone());
//            Log.d(TAG, "drawMypage: name = " + dataBundle.getEmail());
//            Log.d(TAG, "drawMypage: name = " + dataBundle.getMajor());

        }

        @Override
        public void onFailure(Call<List<DataforMypage>> call, Throwable t) {
            Log.d(TAG, "onFailure: " + t.toString());
        }
    }

}
