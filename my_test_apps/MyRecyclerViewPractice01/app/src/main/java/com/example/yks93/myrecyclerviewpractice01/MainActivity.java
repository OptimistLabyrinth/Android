package com.example.yks93.myrecyclerviewpractice01;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.yks93.myrecyclerviewpractice01.adapter.MainAdapter;
import com.example.yks93.myrecyclerviewpractice01.pojo.SingleHorizontal;
import com.example.yks93.myrecyclerviewpractice01.pojo.SingleVertical;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Object> objects = new ArrayList<>();

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: just called SetContentView(int)");

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        Log.d(TAG, "onCreate: Binding RecyclerView " + recyclerView.toString());

        MainAdapter adapter = new MainAdapter(this, getObject());
        Log.d(TAG, "onCreate: New Adapter is created " + adapter.toString());

        recyclerView.setAdapter(adapter);
        Log.d(TAG, "onCreate: Set Adapter to the RecyclerView " + recyclerView.toString());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Log.d(TAG, "onCreate: Set New 'LinearLayoutManager' to the RecyclerView " + recyclerView.toString());

    }

    private ArrayList<Object> getObject() {
        Log.d(TAG, "getObject: ");
        objects.add(getVerticalData().get(0));
        Log.d(TAG, "getObject: objects = " + objects.toString());
        objects.add(getHorizontalData().get(0));
        Log.d(TAG, "getObject: object = " + objects.toString());
        return objects;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    public static ArrayList<SingleVertical> getVerticalData() {
        Log.d(TAG, "getVerticalData: ");
        ArrayList<SingleVertical> singleVerticals = new ArrayList<>();
        singleVerticals.add(new SingleVertical("Charlie Chaplin", "Sir Charles Spencer \"Charlie\" Chaplin, KBE was an English comic actor,....", R.mipmap.charlie));
        singleVerticals.add(new SingleVertical("Mr.Bean", "Mr. Bean is a British sitcom created by Rowan Atkinson and Richard Curtis, and starring Atkinson as the title character.", R.mipmap.mrbean));
        singleVerticals.add(new SingleVertical("Jim Carrey", "James Eugene \"Jim\" Carrey is a Canadian-American actor, comedian, impressionist, screenwriter...", R.mipmap.jim));
        Log.d(TAG, "getVerticalData: singleVerticals = " + singleVerticals.toString());
        return singleVerticals;
    }


    public static ArrayList<SingleHorizontal> getHorizontalData() {
        Log.d(TAG, "getHorizontalData: ");
        ArrayList<SingleHorizontal> singleHorizontals = new ArrayList<>();
        singleHorizontals.add(new SingleHorizontal(R.mipmap.charlie, "Charlie Chaplin", "Sir Charles Spencer \"Charlie\" Chaplin, KBE was an English comic actor,....", "2010/2/1"));
        singleHorizontals.add(new SingleHorizontal(R.mipmap.mrbean, "Mr.Bean", "Mr. Bean is a British sitcom created by Rowan Atkinson and Richard Curtis, and starring Atkinson as the title character.", "2010/2/1"));
        singleHorizontals.add(new SingleHorizontal(R.mipmap.jim, "Jim Carrey", "James Eugene \"Jim\" Carrey is a Canadian-American actor, comedian, impressionist, screenwriter...", "2010/2/1"));
        Log.d(TAG, "getHorizontalData: singleHorizontals = " + singleHorizontals.toString());
        return singleHorizontals;
    }


}
