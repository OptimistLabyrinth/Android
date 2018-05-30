package com.example.yks93.myedittextapp01;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_above, et_bellow;
    Button btn_compare;

    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_above = (EditText) findViewById(R.id.edittext_hello_world);
        et_bellow = (EditText) findViewById(R.id.edittext_byebye_world);
        btn_compare = (Button) findViewById(R.id.button_compare_two);

        btn_compare.setOnClickListener((v) -> {
            onCompareButtonClicked();
        });
    }

    private void onCompareButtonClicked() {
        if (et_above.getText().toString().equals(et_bellow.getText().toString()))
            Toast.makeText(this, "They are the some", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Different", Toast.LENGTH_SHORT).show();
    }


}
