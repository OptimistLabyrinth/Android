package com.example.yks93.myfragment05;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.yks93.myfragment05.fragments.MainFragment;

public class SecondActivity extends AppCompatActivity {

    private final String TAG = "SecondActivity";


    Button button;
    ConstraintLayout layout_root;
    LinearLayout linearLayout_child;

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        layout_root = (ConstraintLayout) findViewById(R.id.layout_root);

    }

    @Override
    protected void onResume() {
        super.onResume();
        fragmentManager = getSupportFragmentManager();

        View view = LayoutInflater.from(this).inflate(R.layout.activity_second_linear_layout, layout_root, true);

        button = (Button) findViewById(R.id.button_second);
        button.setOnClickListener(v -> onButtonClicked());

        linearLayout_child = (LinearLayout) findViewById(R.id.linearLayout_second_activity);
    }

    void onButtonClicked() {
        Fragment fragment = new MainFragment();

//        if (fragmentManager.getBackStackEntryCount() == 0) {
//            FragmentTransaction transaction = fragmentManager.beginTransaction()
//                    .add(R.id.framelayout_simple, fragment, "main")
//                    .addToBackStack("mainFragment");
//            transaction.commit();
//        }
//        else {
//            FragmentTransaction transaction = fragmentManager.beginTransaction()
//                    .replace(R.id.framelayout_simple, fragment, "main")
//                    .addToBackStack("mainFragment");
//            transaction.commit();
//        }

        FragmentTransaction transaction = fragmentManager.beginTransaction()
                .replace(R.id.framelayout_simple, fragment, "main")
                .addToBackStack("mainFragment");
        transaction.commit();
        linearLayout_child.setVisibility(View.GONE);


        Log.d(TAG, "BackStackEntryCount(): " + fragmentManager.getBackStackEntryCount());

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        linearLayout_child.setVisibility(View.VISIBLE);
    }
}
