package com.example.yks93.rooommie777.searchroommate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.yks93.rooommie777.AfterTheFirstClickActivity;
import com.example.yks93.rooommie777.using_mypage_menu.MyPageActivity;
import com.example.yks93.rooommie777.R;
import com.example.yks93.rooommie777.retrofit_package.RetrofitClientInstance;
import com.example.yks93.rooommie777.signup_actions.SignupOneActivity;
import com.example.yks93.rooommie777.static_storage.StaticVarMethods;
import com.example.yks93.rooommie777.trylogin.LoginPageActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecommendRoommateActivity extends AppCompatActivity {

    @BindView(R.id.recyclerview_recommend_roommate)
    RecyclerView recyclerView;

    RecommendRoomateAdapter adapter;

    private List<DataRoommate> roommateList = new ArrayList<>();

    private final String TAG = "RecommendRoommateActiv";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend_roommate);
//        setContentView(R.layout.activity_recommend_roommate2);
        ButterKnife.bind(this);

        adapter = new RecommendRoomateAdapter(roommateList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);

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

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: ");
        super.onResume();

        prepareRecommendingRoommates();
    }



    private void prepareRecommendingRoommates() {
        Log.d(TAG, "prepareRecommendingRoommates: ");
        ArrayList<String> characterList = new ArrayList<>();

        GetRecommendedRoommatesService service = RetrofitClientInstance.getRetrofitInstance()
                .create(GetRecommendedRoommatesService.class);

        Call<List<DataRoommate>> call = service.readRoommateInfo(
                "201404836", "osi", "n", "a", "m",
                "p", "g", "c", "y", "ch",
                "oa", "fd", "d", "s"
        );

        doBackgroundTask(call);

    }

    private void doBackgroundTask(Call<List<DataRoommate>> call) {
        Log.d(TAG, "doBackgroundTask: ");
        call.enqueue(new RecommendCallback());

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

    public class RecommendCallback implements Callback<List<DataRoommate>> {

        private final String TAG = "RecommendCallback";

        @Override
        public void onResponse(Call<List<DataRoommate>> call, Response<List<DataRoommate>> response) {
            List<DataRoommate> receivedRoommateList = response.body();
            Log.d(TAG, "onResponse: code = " + response.code());

            int i = 0;
            for (DataRoommate mate : receivedRoommateList) {
                roommateList.add(mate);
                Log.d(TAG, "onResponse: Added to roommateList " + i + " mate");
            }

            adapter.notifyDataSetChanged();
            Log.d(TAG, "onResponse: notifyDataSetChanged()");

        }

        @Override
        public void onFailure(Call<List<DataRoommate>> call, Throwable t) {
            Log.d(TAG, "onFailure: " + t.toString());
        }
    }


}
