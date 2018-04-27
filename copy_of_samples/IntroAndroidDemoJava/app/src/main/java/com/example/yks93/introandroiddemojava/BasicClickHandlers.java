package com.example.yks93.introandroiddemojava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class BasicClickHandlers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_click_handlers);
        Button secondbutton = (Button) findViewById(R.id.btnClick2);
        secondbutton.setOnClickListener(v -> onSecondBtnClick(v) );
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.activity_basic_click_handlers, menu);
        return true;
    }

    public void firstButtonClicked(View view) {
        SimpleAlertDialog.displayWithOK(this, "firstButton clicked via XML handler");
    }

    private void onSecondBtnClick(View v) {
        SimpleAlertDialog.displayWithOK(this, "secondButton clicked via Java handler in onCreate");
    }



}
