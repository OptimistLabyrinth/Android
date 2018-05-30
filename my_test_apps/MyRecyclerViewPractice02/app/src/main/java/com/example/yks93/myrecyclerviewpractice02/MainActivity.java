package com.example.yks93.myrecyclerviewpractice02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.yks93.myrecyclerviewpractice02.adapter.StringAdapter;
import com.example.yks93.myrecyclerviewpractice02.pojo.StringData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private StringAdapter adapter;
    private List<StringData> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_main);

        adapter = new StringAdapter(dataList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        prepareData();
    }

    private void prepareData() {
        StringData data = new StringData("Mad Max: Fury Road", "Action & Adventure", "2015");
        dataList.add(data);

        data = new StringData("Inside Out", "Animation, Kids & Family", "2015");
        dataList.add(data);

        data = new StringData("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        dataList.add(data);

        data = new StringData("Shaun the Sheep", "Animation", "2015");
        dataList.add(data);

        data = new StringData("The Martian", "Science Fiction & Fantasy", "2015");
        dataList.add(data);

        data = new StringData("Mission: Impossible Rogue Nation", "Action", "2015");
        dataList.add(data);

        data = new StringData("Up", "Animation", "2009");
        dataList.add(data);

        data = new StringData("Star Trek", "Science Fiction", "2009");
        dataList.add(data);

        data = new StringData("The LEGO data", "Animation", "2014");
        dataList.add(data);

        data = new StringData("Iron Man", "Action & Adventure", "2008");
        dataList.add(data);

        data = new StringData("Aliens", "Science Fiction", "1986");
        dataList.add(data);

        data = new StringData("Chicken Run", "Animation", "2000");
        dataList.add(data);

        data = new StringData("Back to the Future", "Science Fiction", "1985");
        dataList.add(data);

        data = new StringData("Raiders of the Lost Ark", "Action & Adventure", "1981");
        dataList.add(data);

        data = new StringData("Goldfinger", "Action & Adventure", "1965");
        dataList.add(data);

        data = new StringData("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        dataList.add(data);

        adapter.notifyDataSetChanged();
    }
}
