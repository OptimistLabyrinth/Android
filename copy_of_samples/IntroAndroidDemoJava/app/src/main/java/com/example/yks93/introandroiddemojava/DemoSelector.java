package com.example.yks93.introandroiddemojava;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

public class DemoSelector extends AppCompatActivity {

    ExpandableListView elvChapters;
    ChaptersListAdapter elaAdapter;

    @Override
    protected void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_demo_selector);
        setUpChaptersListView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_demo_selector, menu);
        return true;
    }


    private void setUpChaptersListView() {
        elvChapters = findViewById(R.id.elvChapters);
        elaAdapter = new ChaptersListAdapter(this);
        elvChapters.setAdapter(elaAdapter);
        elvChapters.setOnChildClickListener(
                (parent, v, groupPosition, childPosition, id) -> elvChaptersOnChildeClick(parent, v, groupPosition, childPosition, id));
    }

    private boolean elvChaptersOnChildeClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        String exerciseTitle = (String) elaAdapter.getChild(groupPosition, childPosition);
        Class<? extends AppCompatActivity> execiseClass = elaAdapter.getExerciseClass(groupPosition, childPosition, id);
        if (execiseClass != null) {
            Toast.makeText(DemoSelector.this, exerciseTitle, Toast.LENGTH_LONG).show();
            startActivity(new Intent(DemoSelector.this, execiseClass));
        } else {
            Toast.makeText(DemoSelector.this, "Exercise Not Available", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

}
