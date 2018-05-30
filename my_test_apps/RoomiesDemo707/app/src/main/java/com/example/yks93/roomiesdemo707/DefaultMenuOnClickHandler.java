package com.example.yks93.roomiesdemo707;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class DefaultMenuOnClickHandler extends AppCompatActivity {

    MenuInflater inflater = null;

    private final String TAG = "DefaultMenuOnClickHandl";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        inflater = getMenuInflater();
        inflater.inflate(R.menu.menus_default, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.login_menu: {

                return true;
            }

            case R.id.signup_menu: {

                return true;
            }

            case R.id.mypage_menu: {

                return true;
            }

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
