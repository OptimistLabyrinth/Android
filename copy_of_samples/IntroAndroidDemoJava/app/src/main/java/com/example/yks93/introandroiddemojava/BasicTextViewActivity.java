package com.example.yks93.introandroiddemojava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;

public class BasicTextViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_text_view);
        Log.d("DEBUG", "onCreate called");
    }

    protected void onResume() {
        super.onResume();
        Log.d("DEBUG", "onResum called");
    }

    protected void onPause() {
        super.onPause();
        Log.d("DEBUG", "onPause called");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_basic_text_view, menu);
        return true;
    }

}
