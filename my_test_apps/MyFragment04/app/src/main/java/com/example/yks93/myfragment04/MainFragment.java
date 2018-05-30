package com.example.yks93.myfragment04;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainFragment extends Fragment {

    @BindView(R.id.btn_go_back)
    Button btnGoBack;
    @BindView(R.id.go_to_second_fragment)
    Button btnSecondFragment;
    @BindView(R.id.move_to_third_fragment)
    Button btnThirdFragment;

    private final String TAG = "MainFragment";

    @Override
    public void onAttach(Context context) {
        Log.d(TAG, "onAttach: ");
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ");
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ButterKnife.bind(this, view);

//        btnGoBack = (Button) view.findViewById(R.id.btn_go_back);
//        btnGoBack.setOnClickListener(v -> onGobackClicked());
//        btnSecondFragment = (Button) view.findViewById(R.id.go_to_second_fragment);
//        btnSecondFragment.setOnClickListener(v -> onGotosecondClicked());
//        btnThirdFragment = (Button) view.findViewById(R.id.move_to_third_fragment);
//        btnThirdFragment.setOnClickListener(v -> onMovetoThirdClicked());

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated: ");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onActivityCreated: ");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d(TAG, "onStart: ");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d(TAG, "onResume: ");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d(TAG, "onPause: ");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d(TAG, "onStop: ");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d(TAG, "onDestroyView: ");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }

    @OnClick(R.id.btn_go_back)
    void onGobackClicked() {
        ((MainActivity) getActivity()).onBackPressed();
    }

    @OnClick(R.id.go_to_second_fragment)
    void onGotosecondClicked() {
        ((MainActivity)getActivity()).onGotoSecondClickedCallback();
    }
    
    @OnClick(R.id.move_to_third_fragment)
    void onMovetoThirdClicked() {
        ((MainActivity)getActivity()).onMovetoThirdClickedCallback();
    }


}
