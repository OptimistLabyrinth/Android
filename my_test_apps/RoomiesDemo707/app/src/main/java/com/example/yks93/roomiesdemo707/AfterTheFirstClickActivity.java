package com.example.yks93.roomiesdemo707;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AfterTheFirstClickActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_the_first_click);

        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menus_default, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.login_menu: {
                Intent intent = new Intent(this, LoginMenuActivity.class);
                startActivity(intent);
                return true;
            }

            case R.id.signup_menu: {
                Intent intent = new Intent(this, SignupOneActivity.class);
                startActivity(intent);
                return true;
            }

            case R.id.mypage_menu: {
                Intent intent = new Intent(this, MyPageActivity.class);
                startActivity(intent);
                return true;
            }

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @OnClick({R.id.searchRoommateImage, R.id.searchRoommateText})
    void searchRoomateClicked(View v) {
        Intent intent = new Intent(this, SearchRoommateActivity.class);
        startActivity(intent);
    }

    @OnClick({R.id.searchHouseImage, R.id.searchHouseText})
    void searchHouseClicked (View v) {
        Intent intent = new Intent(this, SearchHouseActivity.class);
        startActivity(intent);
    }

    @OnClick({R.id.bulletinBoardImage, R.id.bulletinBoardText})
    void bulletinBoardClicked (View v) {
        Intent intent = new Intent(this, BulletinBoardActivity.class);
        startActivity(intent);
    }

    @OnClick({R.id.tipsImage, R.id.tipsText})
    void tipsClicked (View v) {
        Intent intent = new Intent(this, TipsActivity.class);
        startActivity(intent);
    }

    @OnClick({R.id.mypageImage, R.id.mypageText})
    void myPageClicked (View v) {
        Intent intent = new Intent(this, MyPageActivity.class);
        startActivity(intent);
    }

}
