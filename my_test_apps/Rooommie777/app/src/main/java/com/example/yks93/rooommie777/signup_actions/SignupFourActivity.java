package com.example.yks93.rooommie777.signup_actions;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.yks93.rooommie777.AfterSignupFinishActivity;
import com.example.yks93.rooommie777.R;
import com.example.yks93.rooommie777.loading_waiting.LoadingWaitingActivityAfterSignupFour;
import com.example.yks93.rooommie777.retrofit_package.RetrofitClientInstance;
import com.example.yks93.rooommie777.static_storage.StaticVarMethods;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupFourActivity extends AppCompatActivity {

    @BindView(R.id.numberpicker_age_opposite)
    NumberPicker numberPicker_age;
    @BindView(R.id.numberpicker_grade_opposite)
    NumberPicker numberPicker_grade;
    @BindView(R.id.radiogroup_cleanness_opposite)
    RadioGroup radioGroup_cleanness;
    @BindView(R.id.radiogroup_nightfood_opposite)
    RadioGroup radioGroup_nightfood;
    @BindView(R.id.radiogroup_activity_opposite)
    RadioGroup radioGroup_acitivity;
    @BindView(R.id.radiogroup_max_alcohol_opposite)
    RadioGroup radioGroup_max_alcohol;
    @BindView(R.id.radiogroup_alcohol_frequency_opposite)
    RadioGroup radioGroup_freq_alcohol;
    @BindView(R.id.radiogroup_smoking_opposite)
    RadioGroup radioGroup_smoking;
    @BindView(R.id.radiogroup_friend_coming_opposite)
    RadioGroup radioGroup_friend_coming;

    private final String TAG = "SignupFourActivity";
    private final int REQUEST_AFTER_SIGNUP_FOUR = 2121;

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

        numberPicker_age.setMinValue(19);
        numberPicker_age.setMaxValue(35);

        numberPicker_grade.setMinValue(1);
        numberPicker_grade.setMaxValue(4);
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
    void onFinishLoginButtonClicked() {
        Log.d(TAG, "onFinishLoginButtonClicked: ");

        startFinishProcess();
    }

    private void startFinishProcess() {
        Log.d(TAG, "startFinishProcess: ");

        Intent intent = new Intent(this, LoadingWaitingActivityAfterSignupFour.class);
        intent.putExtra(StaticVarMethods.STUD_ID, getIntent().getStringExtra(StaticVarMethods.STUD_ID));

        intent.putExtra(StaticVarMethods.mGENDER, getIntent().getStringExtra(StaticVarMethods.mGENDER));
        intent.putExtra(StaticVarMethods.mAGE, getIntent().getStringExtra(StaticVarMethods.mAGE));
        intent.putExtra(StaticVarMethods.mGRADE, getIntent().getStringExtra(StaticVarMethods.mGRADE));
        intent.putExtra(StaticVarMethods.mAGE, getIntent().getStringExtra(StaticVarMethods.mAGE));
        intent.putExtra(StaticVarMethods.mCLEAN, getIntent().getStringExtra(StaticVarMethods.mCLEAN));
        intent.putExtra(StaticVarMethods.mYASIK, getIntent().getStringExtra(StaticVarMethods.mYASIK));
        intent.putExtra(StaticVarMethods.mCHARACTER, getIntent().getBundleExtra(StaticVarMethods.mCHARACTER));
        intent.putExtra(StaticVarMethods.mACTIVITY, getIntent().getStringExtra(StaticVarMethods.mACTIVITY));
        intent.putExtra(StaticVarMethods.mFREQ_DRINK, getIntent().getStringExtra(StaticVarMethods.mFREQ_DRINK));
        intent.putExtra(StaticVarMethods.mDRINK, getIntent().getStringExtra(StaticVarMethods.mDRINK));
        intent.putExtra(StaticVarMethods.mSMOKE, getIntent().getStringExtra(StaticVarMethods.mSMOKE));

        intent.putExtra(StaticVarMethods.opAGE, String.valueOf(numberPicker_age.getValue()));
        intent.putExtra(StaticVarMethods.opGRADE, String.valueOf(numberPicker_grade.getValue()));
        intent.putExtra(StaticVarMethods.opCLEAN,
                ((RadioButton) radioGroup_cleanness.getChildAt(radioGroup_cleanness.indexOfChild(
                radioGroup_cleanness.findViewById(radioGroup_cleanness.getCheckedRadioButtonId())))).getText().toString());
        intent.putExtra(StaticVarMethods.opYASIK,
                ((RadioButton) radioGroup_nightfood.getChildAt(radioGroup_nightfood.indexOfChild(
                        radioGroup_nightfood.findViewById(radioGroup_nightfood.getCheckedRadioButtonId())))).getText().toString());
        intent.putExtra(StaticVarMethods.opACTIVITY,
                ((RadioButton) radioGroup_acitivity.getChildAt(radioGroup_acitivity.indexOfChild(
                        radioGroup_acitivity.findViewById(radioGroup_acitivity.getCheckedRadioButtonId())))).getText().toString());
        intent.putExtra(StaticVarMethods.opFREQ_DRINK,
                ((RadioButton) radioGroup_freq_alcohol.getChildAt(radioGroup_freq_alcohol.indexOfChild(
                        radioGroup_freq_alcohol.findViewById(radioGroup_freq_alcohol.getCheckedRadioButtonId())))).getText().toString());
        intent.putExtra(StaticVarMethods.opDRINK,
                ((RadioButton) radioGroup_max_alcohol.getChildAt(radioGroup_max_alcohol.indexOfChild(
                        radioGroup_max_alcohol.findViewById(radioGroup_max_alcohol.getCheckedRadioButtonId())))).getText().toString());
        intent.putExtra(StaticVarMethods.opSMOKE,
                ((RadioButton) radioGroup_smoking.getChildAt(radioGroup_smoking.indexOfChild(
                        radioGroup_smoking.findViewById(radioGroup_smoking.getCheckedRadioButtonId())))).getText().toString());
        intent.putExtra(StaticVarMethods.AGREE_WITH,
                ((RadioButton) radioGroup_friend_coming.getChildAt(radioGroup_friend_coming.indexOfChild(
                        radioGroup_friend_coming.findViewById(radioGroup_friend_coming.getCheckedRadioButtonId())))).getText().toString());

        startActivityForResult(intent, REQUEST_AFTER_SIGNUP_FOUR);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Intent intent = new Intent(this, AfterSignupFinishActivity.class);
        startActivity(intent);
    }
}

/*
    InsertMatchAllService service = RetrofitClientInstance.getRetrofitInstance().create(InsertMatchAllService.class);
    Call<List<DataAllMatch>> call = service.insertAllMatchData(
            getIntent().getStringExtra(StaticVarMethods.mGENDER),
            getIntent().getStringExtra(StaticVarMethods.mAGE),
            getIntent().getStringExtra(StaticVarMethods.mGRADE),
            getIntent().getStringExtra(StaticVarMethods.mCLEAN),
            getIntent().getStringExtra(StaticVarMethods.mYASIK),
            tempStorage,
            getIntent().getStringExtra(StaticVarMethods.mACTIVITY),
            getIntent().getStringExtra(StaticVarMethods.mFREQ_DRINK),
            getIntent().getStringExtra(StaticVarMethods.mDRINK),
            getIntent().getStringExtra(StaticVarMethods.mSMOKE),

            String.valueOf(numberPicker_age.getValue()),
            String.valueOf(numberPicker_grade.getValue()),
            ((RadioButton) radioGroup_cleanness.getChildAt(radioGroup_cleanness.indexOfChild(
                    radioGroup_cleanness.findViewById(radioGroup_cleanness.getCheckedRadioButtonId())))).getText().toString(),
            ((RadioButton) radioGroup_nightfood.getChildAt(radioGroup_nightfood.indexOfChild(
                    radioGroup_nightfood.findViewById(radioGroup_nightfood.getCheckedRadioButtonId())))).getText().toString(),
            ((RadioButton) radioGroup_acitivity.getChildAt(radioGroup_acitivity.indexOfChild(
                    radioGroup_acitivity.findViewById(radioGroup_acitivity.getCheckedRadioButtonId())))).getText().toString(),
            ((RadioButton) radioGroup_freq_alcohol.getChildAt(radioGroup_freq_alcohol.indexOfChild(
                    radioGroup_freq_alcohol.findViewById(radioGroup_freq_alcohol.getCheckedRadioButtonId())))).getText().toString(),
            ((RadioButton) radioGroup_max_alcohol.getChildAt(radioGroup_max_alcohol.indexOfChild(
                    radioGroup_max_alcohol.findViewById(radioGroup_max_alcohol.getCheckedRadioButtonId())))).getText().toString(),
            ((RadioButton) radioGroup_smoking.getChildAt(radioGroup_smoking.indexOfChild(
                    radioGroup_smoking.findViewById(radioGroup_smoking.getCheckedRadioButtonId())))).getText().toString(),
            ((RadioButton) radioGroup_friend_coming.getChildAt(radioGroup_friend_coming.indexOfChild(
                    radioGroup_friend_coming.findViewById(radioGroup_friend_coming.getCheckedRadioButtonId())))).getText().toString()
    );

        call.enqueue(new Callback<List<DataAllMatch>>() {
            @Override
            public void onResponse(Call<List<DataAllMatch>> call, Response<List<DataAllMatch>> response) {
                    Log.d(TAG, "onResponse: ");
                    int code = response.code();
                    Log.d(TAG, "onResponse: code = " + code);



                    }

            @Override
            public void onFailure(Call<List<DataAllMatch>> call, Throwable t) {
                    Log.d(TAG, "onFailure: ");
            }

        });

    }
*/
