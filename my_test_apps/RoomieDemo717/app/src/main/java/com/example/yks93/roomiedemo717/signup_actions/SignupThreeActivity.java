package com.example.yks93.roomiedemo717.signup_actions;

import android.content.Intent;
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
import com.example.yks93.roomiedemo717.static_storage.StaticVarMethods;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupThreeActivity extends AppCompatActivity {

    @BindView(R.id.radiogroup_gender_myself)
    RadioGroup radioGroup_gender;
    @BindView(R.id.numberpicker_age_myself)
    NumberPicker numberPicker_age;
    @BindView(R.id.numberpicker_grade_myself)
    NumberPicker numberPicker_grade;
    @BindView(R.id.checkbox_01_myself)
    CheckBox checkbox_01_myself;
    @BindView(R.id.checkbox_02_myself)
    CheckBox checkbox_02_myself;
    @BindView(R.id.checkbox_03_myself)
    CheckBox checkbox_03_myself;
    @BindView(R.id.checkbox_04_myself)
    CheckBox checkbox_04_myself;
    @BindView(R.id.checkbox_05_myself)
    CheckBox checkbox_05_myself;
    @BindView(R.id.checkbox_06_myself)
    CheckBox checkbox_06_myself;
    @BindView(R.id.checkbox_07_myself)
    CheckBox checkbox_07_myself;
    @BindView(R.id.checkbox_08_myself)
    CheckBox checkbox_08_myself;
    @BindView(R.id.checkbox_09_myself)
    CheckBox checkbox_09_myself;
    @BindView(R.id.checkbox_10_myself)
    CheckBox checkbox_10_myself;
    @BindView(R.id.checkbox_11_myself)
    CheckBox checkbox_11_myself;
    @BindView(R.id.checkbox_12_myself)
    CheckBox checkbox_12_myself;
    @BindView(R.id.radiogroup_cleanness_myself)
    RadioGroup radiogroup_cleanness;
    @BindView(R.id.radiogroup_nightfood_myself)
    RadioGroup radiogroup_nightfood;
    @BindView(R.id.radiogroup_activity_myself)
    RadioGroup radiogroup_activity;
    @BindView(R.id.radiogroup_max_alcohol_myself)
    RadioGroup radiogroup_max_alcohol;
    @BindView(R.id.radiogroup_alcohol_frequency_myself)
    RadioGroup radiogroup_alcohol_frequency;
    @BindView(R.id.radiogroup_smoking_myself)
    RadioGroup radiogroup_smoking;
    @BindView(R.id.btn_move_to_signup_four)
    Button button;

    ArrayList<String> checkedPersonalities = new ArrayList<>();

    private final String TAG = "SignupThreeActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_three);
        ButterKnife.bind(this);

        initialize();

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

    void initialize() {
        numberPicker_age.setMinValue(19);
        numberPicker_age.setMaxValue(35);

        numberPicker_grade.setMinValue(1);
        numberPicker_grade.setMaxValue(4);
    }

    @OnClick(R.id.btn_move_to_signup_four)
    void onMovetoSignupFourButtonClicked() {
        Log.d(TAG, "onMovetoSignupFourButtonClicked: ");

        startIntentSignupFourActivity();

    }

    private void getCheckboxSelected() {
        ArrayList<CheckBox> checkBoxesAll = new ArrayList<>();
        checkBoxesAll.add(checkbox_01_myself);
        checkBoxesAll.add(checkbox_02_myself);
        checkBoxesAll.add(checkbox_03_myself);
        checkBoxesAll.add(checkbox_04_myself);
        checkBoxesAll.add(checkbox_05_myself);
        checkBoxesAll.add(checkbox_06_myself);
        checkBoxesAll.add(checkbox_07_myself);
        checkBoxesAll.add(checkbox_08_myself);
        checkBoxesAll.add(checkbox_09_myself);
        checkBoxesAll.add(checkbox_10_myself);
        checkBoxesAll.add(checkbox_11_myself);
        checkBoxesAll.add(checkbox_12_myself);

        for (CheckBox cb : checkBoxesAll) {
            if (cb.isChecked())
                checkedPersonalities.add(cb.getText().toString());
        }
    }

    private void startIntentSignupFourActivity() {
        Log.d(TAG, "startIntentSignupFourActivity: ");

        Intent intent = new Intent(this, SignupFourActivity.class);

        inputPassingValues(intent);

        startActivity(intent);
    }

    private void inputPassingValues(Intent intent) {
        intent.putExtra(StaticVarMethods.mGENDER,
                ((RadioButton) radioGroup_gender.getChildAt(radioGroup_gender.indexOfChild(
                        radioGroup_gender.findViewById(radioGroup_gender.getCheckedRadioButtonId())))).getText().toString());
        intent.putExtra(StaticVarMethods.mAGE, String.valueOf(numberPicker_age.getValue()));
        intent.putExtra(StaticVarMethods.mGRADE, String.valueOf(numberPicker_grade.getValue()));
        intent.putExtra(StaticVarMethods.mCLEAN,
                ((RadioButton) radiogroup_cleanness.getChildAt(radiogroup_cleanness.indexOfChild(
                        radiogroup_cleanness.findViewById(radiogroup_cleanness.getCheckedRadioButtonId())))).getText().toString());
        intent.putExtra(StaticVarMethods.mYASIK,
                ((RadioButton) radiogroup_cleanness.getChildAt(radiogroup_cleanness.indexOfChild(
                        radiogroup_cleanness.findViewById(radiogroup_cleanness.getCheckedRadioButtonId())))).getText().toString());

        Bundle personalityBundle = new Bundle();
        int i = 0;
        int list_length = checkedPersonalities.size();
        while (i < list_length) {
            personalityBundle.putString(String.valueOf(i), checkedPersonalities.get(i));
            ++i;
        }
        personalityBundle.putInt(StaticVarMethods.mCharacterListLength, list_length);

        intent.putExtra(StaticVarMethods.mCHARACTER, personalityBundle);
        intent.putExtra(StaticVarMethods.mACTIVITY,
                ((RadioButton) radiogroup_activity.getChildAt(radiogroup_activity.indexOfChild(
                        radiogroup_activity.findViewById(radiogroup_activity.getCheckedRadioButtonId())))).getText().toString());
        intent.putExtra(StaticVarMethods.mFREQ_DRINK,
                ((RadioButton) radiogroup_alcohol_frequency.getChildAt(radiogroup_alcohol_frequency.indexOfChild(
                        radiogroup_alcohol_frequency.findViewById(radiogroup_alcohol_frequency.getCheckedRadioButtonId())))).getText().toString());
        intent.putExtra(StaticVarMethods.mDRINK,
                ((RadioButton) radiogroup_max_alcohol.getChildAt(radiogroup_max_alcohol.indexOfChild(
                        radiogroup_max_alcohol.findViewById(radiogroup_max_alcohol.getCheckedRadioButtonId())))).getText().toString());
        intent.putExtra(StaticVarMethods.mSMOKE,
                ((RadioButton) radiogroup_smoking.getChildAt(radiogroup_smoking.indexOfChild(
                        radiogroup_smoking.findViewById(radiogroup_smoking.getCheckedRadioButtonId())))).getText().toString());
    }

//    private int myGenderValueConversion() {
//
//    }
//
//    private int myCleanValueConversion() {
//
//    }
//
//    private int myYasikValueConversion() {
//
//    }
//
//    private int myCharacterConversion() {
//
//        traverseAndCompare(" ");
//
//
//    }
//
//    private int traverseAndCompare(String s) {
//
//    }
//
//    private int myOutsideActivityConversion() {
//
//    }
//
//    private int myFreqDrinkConversion() {
//
//    }
//
//    private int mySmokeConversion() {
//
//    }

}

//        SendSignupThreeService service = RetrofitClientInstance.getRetrofitInstance().create(SendSignupThreeService.class);
//        Call<List<SignupThreeData>> call = service.sendSignupThreeData(
//                ((RadioButton) radioGroup_gender.getChildAt(radioGroup_gender.indexOfChild(
//                        radioGroup_gender.findViewById(radioGroup_gender.getCheckedRadioButtonId())))).getText().toString(),
//                String.valueOf(numberPicker_age.getValue()),
//                String.valueOf(numberPicker_grade.getValue()),
//                checkedPersonalities,
//                ((RadioButton) radiogroup_cleanness.getChildAt(radiogroup_cleanness.indexOfChild(
//                        radiogroup_cleanness.findViewById(radiogroup_cleanness.getCheckedRadioButtonId())))).getText().toString(),
//                ((RadioButton) radiogroup_nightfood.getChildAt(radiogroup_nightfood.indexOfChild(
//                        radiogroup_nightfood.findViewById(radiogroup_nightfood.getCheckedRadioButtonId())))).getText().toString(),
//                ((RadioButton) radiogroup_activity.getChildAt(radiogroup_activity.indexOfChild(
//                        radiogroup_activity.findViewById(radiogroup_activity.getCheckedRadioButtonId())))).getText().toString(),
//                ((RadioButton) radiogroup_max_alcohol.getChildAt(radiogroup_max_alcohol.indexOfChild(
//                        radiogroup_max_alcohol.findViewById(radiogroup_max_alcohol.getCheckedRadioButtonId())))).getText().toString(),
//                ((RadioButton) radiogroup_alcohol_frequency.getChildAt(radiogroup_alcohol_frequency.indexOfChild(
//                        radiogroup_alcohol_frequency.findViewById(radiogroup_alcohol_frequency.getCheckedRadioButtonId())))).getText().toString(),
//                ((RadioButton) radiogroup_smoking.getChildAt(radiogroup_smoking.indexOfChild(
//                        radiogroup_smoking.findViewById(radiogroup_smoking.getCheckedRadioButtonId())))).getText().toString()
//        );
//
//        call.enqueue(new Callback<List<SignupThreeData>>() {
//            @Override
//            public void onResponse(Call<List<SignupThreeData>> call, Response<List<SignupThreeData>> response) {
//                Log.d(TAG, "onResponse: ");
//                int code = response.code();
//
//                if (code != 200)
//                    this.onFailure(call, new Throwable());
//            }
//
//            @Override
//            public void onFailure(Call<List<SignupThreeData>> call, Throwable t) {
//                Log.d(TAG, "onFailure: RETRYING");
//                call.clone().enqueue(this);
//            }
//        });
