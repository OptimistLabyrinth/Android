package com.example.yks93.roomiedemo717.searchroommate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.yks93.roomiedemo717.R;
import com.example.yks93.roomiedemo717.retrofit_package.RetrofitClientInstance;
import com.example.yks93.roomiedemo717.static_storage.StaticVarMethods;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchRoommateActivity extends AppCompatActivity {

    @BindView(R.id.recyclerview_searchroommate)
    RecyclerView recyclerView;

    SearchRoommateAdapter adapter;
    RecyclerView.LayoutManager layoutManager;

    private List<RoommateItem> dataList = new ArrayList<>();
    private List<RoommateData> dataFromServerList = new ArrayList<>();
    private int tryState = StaticVarMethods.TRY_ONCE_MORE;

    private final String TAG = "SearchRoommateActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_roommate);
        ButterKnife.bind(this);

        adapter = new SearchRoommateAdapter(dataList);
        Log.d(TAG, "onCreate: NEW Adapter");
        layoutManager = new LinearLayoutManager(getApplicationContext());
        Log.d(TAG, "onCreate: NEW LayoutManager");
        recyclerView.setLayoutManager(layoutManager);
        Log.d(TAG, "onCreate: SET Layout Manager");
        recyclerView.setAdapter(adapter);
        Log.d(TAG, "onCreate: SET Adapter");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d(TAG, "onCreateOptionsMenu: ");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(TAG, "onOptionsItemSelected: ");
        return super.onOptionsItemSelected(item);
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

        prepareRoommateListPage();
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

    private void prepareRoommateListPage() {
        Log.d(TAG, "prepareRoommateListPage: ");

        GetRoommateTableService service = RetrofitClientInstance.getRetrofitInstance().create(GetRoommateTableService.class);
        Call<List<RoommateData>> call = service.getMatchingData(
                "s", "i", "pwd", "n", "g", "phone", "", "m"
        );
        Log.d(TAG, "prepareRoommateListPage: Call<T> initialization finished");

        doBackgroundTask(call);

//        while (tryState != StaticVarMethods.FAILURE)
//        {
//            Call<List<RoommateData>> call2 = call.clone();
//            doBackgroundTask(call2);
//        }

//        switch (tryState)
//        {
//            case StaticVarMethods.FAILURE:
//                Log.d(TAG, "prepareRoommateListPage: FAILURE");
//                break;
//
//            case StaticVarMethods.SUCCESS:
//                Log.d(TAG, "prepareRoommateListPage: SUCCESS");
//                passDataToSearchRoommateRecyclerAdapter();
//                break;
//        }

    }

    private void doBackgroundTask(Call<List<RoommateData>> call) {
        Log.d(TAG, "doBackgroundTask: ");
        call.enqueue(new Callback<List<RoommateData>>() {
            @Override
            public void onResponse(Call<List<RoommateData>> call, Response<List<RoommateData>> response) {
                Log.d(TAG, "onResponse: ");
                int code = response.code();
                Log.d(TAG, "onResponse: code = " + code);
                List<RoommateData> contents = response.body();

//                if (code != 200) {
//                    Log.d(TAG, "ERROR: Networking Task Failed");
//                    if (StaticVarMethods.NETWORK_TASK_COUNT > 0)
//                    --StaticVarMethods.NETWORK_TASK_COUNT;
//                }
//                else {
//                    tryState = StaticVarMethods.SUCCESS;
//
//                    Log.d(TAG, "response size = " + response.body().size());
//
//                    for (RoommateData rd : response.body()) {
//                        dataFromServerList.add(rd);
//                    }
//                }
                int i = 1;
                for (RoommateData rd : contents) {
                    dataFromServerList.add(rd);
                    Log.d(TAG, "onResponse: ADDED " + i + " rommmate data");
                    ++i;
                }
                passDataToSearchRoommateRecyclerAdapter();

                adapter.notifyDataSetChanged();

                call.cancel();
            }

            @Override
            public void onFailure(Call<List<RoommateData>> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
            }

        });

    }

    private void passDataToSearchRoommateRecyclerAdapter() {
        Log.d(TAG, "passDataToSearchRoommateRecyclerAdapter: ");

        int i = 1;

        for (RoommateData rd : dataFromServerList) {
            Log.d(TAG, "passDataToSearchRoommateRecyclerAdapter: passing " + i);
            dataList.add(
                    new RoommateItem(
                            rd.getStud_id(),
                            rd.getId(),
                            rd.getPwd(),
                            rd.getName(),
                            rd.getGender(),
                            rd.getPhone(),
                            rd.getEmail(),
                            rd.getMajor()
                    )
            );
            ++i;

        }

    }

}
