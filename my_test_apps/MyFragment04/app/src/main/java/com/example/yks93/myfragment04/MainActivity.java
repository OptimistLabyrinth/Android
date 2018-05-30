package com.example.yks93.myfragment04;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_move_to_main_fragment)
    TextView textView;
    @BindView(R.id.tv_move_to_second_activity)
    TextView textView2;
    @BindView(R.id.layout_main_activity)
    LinearLayout layout_main_activity;

    FragmentManager fragmentManager;

    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart: ");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: ");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: ");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }

    @OnClick(R.id.tv_move_to_main_fragment)
    void onClickTextview() {
        Log.d(TAG, "onClickTextview: ");
        layout_main_activity.setVisibility(View.GONE);
        Fragment mainFragment = new MainFragment();
        fragmentManager = getSupportFragmentManager();

        Log.d(TAG, "onClickTextview: FragmentManager Created");
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()
                .replace(R.id.fragment_layout, mainFragment)
                .addToBackStack("main_fragment");
        Log.d(TAG, "onClickTextview: Added To BackStack - main fragment");
        fragmentTransaction.commit();
        Log.d(TAG, "onClickTextview: FragmentTransaction Commit() called");
    }

    @OnClick(R.id.tv_move_to_second_activity)
    void onClickTextView2() {
        Log.d(TAG, "onClickTextView2: ");

        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    void onGotoSecondClickedCallback() {
        Log.d(TAG, "onGotoSecondClickedCallback: ");
        fragmentManager.popBackStack("main_fragment", 0);
        Log.d(TAG, "onGotoSecondClickedCallback: Popped from the BackStack");
        Fragment secondFragment = new SecondFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()
                .replace(R.id.fragment_layout, secondFragment)
                .addToBackStack("second_fragment");
        Log.d(TAG, "onGotoSecondClickedCallback: Added To Back Stack - second fragment");
        fragmentTransaction.commit();
        Log.d(TAG, "onGotoSecondClickedCallback: Commit() called");
    }

    void onMovetoThirdClickedCallback() {
        Log.d(TAG, "onMovetoThirdClickedCallback: ");
        fragmentManager.popBackStack("main_fragment", 0);
        Log.d(TAG, "onMovetoThirdClickedCallback: Popped from the BackStack");
        Fragment thirdFragment = new ThirdFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()
                .replace(R.id.fragment_layout, thirdFragment)
                .addToBackStack("third_fragemnt");
        Log.d(TAG, "onMovetoThirdClickedCallback: Added to the BackStack - third fragmemt");
        fragmentTransaction.commit();
        Log.d(TAG, "onGotoSecondClickedCallback: Commit() called");
    }

    @Override
    public void onBackPressed() {
        Log.d(TAG, "onBackPressed: ");
        super.onBackPressed();

        if (fragmentManager.getBackStackEntryCount() == 0) {
            layout_main_activity.setVisibility(View.VISIBLE);
        }

        Log.d(TAG, "BackStackEntryCount() : " + fragmentManager.getBackStackEntryCount());

    }

}
