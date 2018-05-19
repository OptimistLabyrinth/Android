package com.example.yks93.roomiesdemo707;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AfterTheFirstClickActivity extends AppCompatActivity {

    @BindView(R.id.searchRoommateImage)
    ImageButton searchRoomate = null;

    @BindView(R.id.searchHouseImage)
    ImageButton searchHouse = null;

    @BindView(R.id.bulletinBoardImage)
    ImageButton bulletinBoard = null;

    @BindView(R.id.tipsImage)
    ImageButton tips = null;

    @BindView(R.id.mypageImage)
    ImageButton myPage = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_the_first_click);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.searchRoommateImage)
    void searchRoomateClicked(View v) {

    }

    @OnClick(R.id.searchHouseImage)
    void searchHouseClicked (View v) {

    }

    @OnClick(R.id.bulletinBoardImage)
    void bulletinBoardClicked (View v) {

    }

    @OnClick(R.id.tipsImage)
    void tipsClicked (View v) {

    }

    @OnClick(R.id.mypageImage)
    void myPageClicked (View v) {

    }

}
