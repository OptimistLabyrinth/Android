package com.example.yks93.roomiedemo717.signup_actions;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.yks93.roomiedemo717.R;
import com.example.yks93.roomiedemo717.retrofit_package.RetrofitClientInstance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupFourActivity extends AppCompatActivity{

    @BindView(R.id.numberpicker_age_opposite)
    NumberPicker numberpicker_age;
    @BindView(R.id.numberpicker_grade_opposite)
    NumberPicker numberpicker_grade;
    @BindView(R.id.checkbox_01_opposite)
    CheckBox checkbox_01;
    @BindView(R.id.checkbox_02_opposite)
    CheckBox checkbox_02;
    @BindView(R.id.checkbox_03_opposite)
    CheckBox checkbox_03;
    @BindView(R.id.checkbox_04_opposite)
    CheckBox checkbox_04;
    @BindView(R.id.checkbox_05_opposite)
    CheckBox checkbox_05;
    @BindView(R.id.checkbox_06_opposite)
    CheckBox checkbox_06;
    @BindView(R.id.checkbox_07_opposite)
    CheckBox checkbox_07;
    @BindView(R.id.checkbox_08_opposite)
    CheckBox checkbox_08;
    @BindView(R.id.checkbox_09_opposite)
    CheckBox checkbox_09;
    @BindView(R.id.checkbox_10_opposite)
    CheckBox checkbox_10;
    @BindView(R.id.checkbox_11_opposite)
    CheckBox checkbox_11;
    @BindView(R.id.checkbox_12_opposite)
    CheckBox checkbox_12;
    @BindView(R.id.radiogroup_cleanness_opposite)
    RadioGroup radiogroup_cleanness;
    @BindView(R.id.radiogroup_nightfood_opposite)
    RadioGroup radiogroup_nightfood;
    @BindView(R.id.radiogroup_activity_opposite)
    RadioGroup radiogroup_activity;
    @BindView(R.id.radiogroup_max_alcohol_opposite)
    RadioGroup radiogroup_max_alcohol;
    @BindView(R.id.radiogroup_alcohol_frequency_opposite)
    RadioGroup radiogroup_alcohol_frequency;
    @BindView(R.id.radiogroup_smoking_opposite)
    RadioGroup radiogroup_smoking;
    @BindView(R.id.radiogroup_friend_coming_opposite)
    RadioGroup radiogroup_friend_coming_opposite;
    @BindView(R.id.btn_signup_finish)
    Button button;

    ArrayList<String> checkedPersonalities = new ArrayList<>();

    private final String TAG = "SignupFourActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_four);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart: ");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: ");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: ");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }

    @OnClick(R.id.btn_signup_finish)
    void onFinishButtonClicked() {
        Log.d(TAG, "onFinishButtonClicked: ");
        beginFinishProcess();
    }

    void beginFinishProcess() {
        Log.d(TAG, "onStartRetrofitProcess: ");

        int code = 0;

        SendSignupFourService service = RetrofitClientInstance.getRetrofitInstance().create(SendSignupFourService.class);
        Call<List<SignupFourData>> call = service.sendSignupFourData(
                String.valueOf(numberpicker_age.getValue()),
                String.valueOf(numberpicker_grade.getValue()),
                checkedPersonalities,
                ((RadioButton) radiogroup_cleanness.getChildAt(radiogroup_cleanness.indexOfChild(
                        radiogroup_cleanness.findViewById(radiogroup_cleanness.getCheckedRadioButtonId())))).getText().toString(),
                ((RadioButton) radiogroup_nightfood.getChildAt(radiogroup_nightfood.indexOfChild(
                        radiogroup_nightfood.findViewById(radiogroup_nightfood.getCheckedRadioButtonId())))).getText().toString(),
                ((RadioButton) radiogroup_activity.getChildAt(radiogroup_activity.indexOfChild(
                        radiogroup_activity.findViewById(radiogroup_activity.getCheckedRadioButtonId())))).getText().toString(),
                ((RadioButton) radiogroup_max_alcohol.getChildAt(radiogroup_max_alcohol.indexOfChild(
                        radiogroup_max_alcohol.findViewById(radiogroup_max_alcohol.getCheckedRadioButtonId())))).getText().toString(),
                ((RadioButton) radiogroup_alcohol_frequency.getChildAt(radiogroup_alcohol_frequency.indexOfChild(
                        radiogroup_alcohol_frequency.findViewById(radiogroup_alcohol_frequency.getCheckedRadioButtonId())))).getText().toString(),
                ((RadioButton) radiogroup_smoking.getChildAt(radiogroup_smoking.indexOfChild(
                        radiogroup_smoking.findViewById(radiogroup_smoking.getCheckedRadioButtonId())))).getText().toString(),
                ((RadioButton) radiogroup_friend_coming_opposite.getChildAt(radiogroup_friend_coming_opposite.indexOfChild(
                        radiogroup_friend_coming_opposite.findViewById(radiogroup_friend_coming_opposite.getCheckedRadioButtonId())))).getText().toString()
        );

        call.enqueue(new Callback<List<SignupFourData>>() {
            @Override
            public void onResponse(Call<List<SignupFourData>> call, Response<List<SignupFourData>> response) {
                Log.d(TAG, "onResponse: ");
                int code = response.code();

                if (code != 200)
                    this.onFailure(call, new Throwable());
            }

            @Override
            public void onFailure(Call<List<SignupFourData>> call, Throwable t) {
                Log.d(TAG, "onFailure: RETRYING");
                call.clone().enqueue(this);
            }
        });

        while (code != 200) {
            try {
                Response<List<SignupFourData>> response = call.clone().execute();
                code = response.code();
            } catch (IOException e) {
                Log.d(TAG, "ERROR!! beginFinishProcess: ");
                e.printStackTrace();
            }

            
        }

    }

    private void getCheckBoxSelectedOpposite() {
        ArrayList<CheckBox> checkBoxeList = new ArrayList<>();
        checkBoxeList.add(checkbox_01);
        checkBoxeList.add(checkbox_02);
        checkBoxeList.add(checkbox_03);
        checkBoxeList.add(checkbox_04);
        checkBoxeList.add(checkbox_05);
        checkBoxeList.add(checkbox_06);
        checkBoxeList.add(checkbox_07);
        checkBoxeList.add(checkbox_08);
        checkBoxeList.add(checkbox_09);
        checkBoxeList.add(checkbox_10);
        checkBoxeList.add(checkbox_11);
        checkBoxeList.add(checkbox_12);

        for (CheckBox cb : checkBoxeList) {
            if (cb.isChecked())
                checkedPersonalities.add(cb.getText().toString());
        }

    }



}
