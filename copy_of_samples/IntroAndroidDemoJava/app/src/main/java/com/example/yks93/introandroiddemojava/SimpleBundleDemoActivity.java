package com.example.yks93.introandroiddemojava;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SimpleBundleDemoActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_bundle_demo);
        String initialText = getIntent().getStringExtra("text");
        TextView tvDisplayText = (TextView) findViewById(R.id.tvDisplayText);
        if (initialText != null)
            tvDisplayText.setText(initialText);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_simple_bundle_demo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home :
                Intent i = new Intent(this, ActionBarMenuActivity.class);
                startActivity(i);
                break;
            default:
                break;
        }
        return true;
    }

}
