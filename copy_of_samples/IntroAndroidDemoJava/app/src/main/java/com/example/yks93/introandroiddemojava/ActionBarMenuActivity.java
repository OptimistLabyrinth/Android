package com.example.yks93.introandroiddemojava;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class ActionBarMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_menu);
        getActionBar().setTitle("Click an Icon");
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.activity_action_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_toast :
                Toast.makeText(this, "Toasted", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_launch : {
                Intent i = new Intent(this, SimpleBundleDemoActivity.class);
                startActivity(i);
                break;
            }
            default:
                break;
        }
        return true;
    }

}
