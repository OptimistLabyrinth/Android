package com.example.yks93.myfragment04;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AAAFragment extends Fragment {

    @BindView(R.id.btn_go_back)
    Button btnGoBack;
    @BindView(R.id.go_to_second_fragment)
    Button btnSecondFragment;
    @BindView(R.id.move_to_third_fragment)
    Button btnThirdFragment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);

//        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
