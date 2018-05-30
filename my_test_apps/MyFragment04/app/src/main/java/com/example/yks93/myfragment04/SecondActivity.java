package com.example.yks93.myfragment04;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecondActivity extends AppCompatActivity {

    @BindView(R.id.btn_one)
    Button button1;
    @BindView(R.id.btn_two)
    Button button2;
    @BindView(R.id.btn_three)
    Button button3;
    @BindView(R.id.btn_four)
    Button button4;
    @BindView(R.id.layout_root)
    ConstraintLayout layouRoot;
    @BindView(R.id.layout_second_fragment)
    FrameLayout layoutChild;

    FragmentManager fragmentManager;


    private final String TAG = "SecondActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);

    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: ");
        super.onResume();

        fragmentManager = getSupportFragmentManager();
        Log.d(TAG, "onResume: BackStackEntryCount(): " + fragmentManager.getBackStackEntryCount());
    }

    @OnClick(R.id.btn_one)
    void onButtonOneClicked() {
        Log.d(TAG, "onButtonOneClicked: ");

        Fragment aaaFragment = new AAAFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction()
                .replace(R.id.layout_second_fragment, aaaFragment)
                .addToBackStack("main_fragment_from_second");
        transaction.commit();
        layoutChild.setVisibility(View.GONE);
    }

    @OnClick(R.id.btn_two)
    void onButtonTwoClicked() {
        Log.d(TAG, "onButtonTwoClicked: ");

        Fragment mainFragment = new MainFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction()
                .replace(R.id.layout_second_fragment, mainFragment)
                .addToBackStack("main_fragment_from_second");
        transaction.commit();
        layoutChild.setVisibility(View.GONE);
    }

    @OnClick(R.id.btn_three)
    void onButtonThreeClicked() {
        Log.d(TAG, "onButtonThreeClicked: ");

        Fragment secondFragment = new SecondFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction()
                .replace(R.id.layout_second_fragment, secondFragment)
                .addToBackStack("second_fragment_from_second");
        transaction.commit();
        layoutChild.setVisibility(View.GONE);
    }

    @OnClick(R.id.btn_four)
    void onButtonFourClicked() {
        Log.d(TAG, "onButtonFourClicked: ");

        Fragment thirdFragment = new ThirdFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction()
                .replace(R.id.layout_second_fragment, thirdFragment)
                .addToBackStack("third_fragment_from_second");
        transaction.commit();
        layoutChild.setVisibility(View.GONE);

    }


    @Override
    public void onBackPressed() {
        Log.d(TAG, "onBackPressed: ");
        super.onBackPressed();

        if (fragmentManager.getBackStackEntryCount() == 0) {
            layoutChild.setVisibility(View.VISIBLE);
        }

        Log.d(TAG, "onBackPressed: BackStackEntryCount(): " + fragmentManager.getBackStackEntryCount());

    }

}
