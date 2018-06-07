package com.example.yks93.rooommie777;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.example.yks93.rooommie777.signup_actions.SignupOneActivity;
import com.example.yks93.rooommie777.trylogin.LoginPageActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AfterSignupFinishActivity extends AppCompatActivity {

    @BindView(R.id.button_go_to_main_page)
    Button button_go_to_main_page;
    @BindView(R.id.button_go_to_login_page)
    Button button_go_to_login_page;

    private final String TAG = "AfterSignupFinishActiv";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_signup_finish);
        ButterKnife.bind(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menus_default, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.login_menu:
                onGotoLoginPageClicked();
                break;

            case R.id.signup_menu:
                onSignupMenuClickedinAfterSignupFinish();
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

    @OnClick(R.id.button_go_to_main_page)
    void onGotoMainPageClicked() {
        Intent intent = new Intent(this, AfterTheFirstClickActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.button_go_to_login_page)
    void onGotoLoginPageClicked() {
        Intent intent = new Intent(this, LoginPageActivity.class);
        startActivity(intent);
    }

    void onSignupMenuClickedinAfterSignupFinish() {
        new AlertDialog.Builder(this)
                .setMessage(R.string.signup_finish_label)
                .setPositiveButton(R.string.OK_button, (d, i) -> {})
                .create().show();
    }

    void onGotoHomeMenuClicked() {
        Intent i = new Intent(this, AfterTheFirstClickActivity.class);
        startActivity(i);
    }

}
