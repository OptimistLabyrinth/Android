package com.example.yks93.roomiedemo717.signup_actions;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;

import com.example.yks93.roomiedemo717.AfterSignupFinishActivity;
import com.example.yks93.roomiedemo717.loading_waiting.LoadingWaitingFragment;
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

public class SignupFourActivity extends AppCompatActivity{

    @BindView(R.id.numberpicker_age_opposite)
    NumberPicker numberpicker_age;
    @BindView(R.id.numberpicker_grade_opposite)
    NumberPicker numberpicker_grade;
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
    @BindView(R.id.frameLayout_of_signup_four)
    FrameLayout frameLayout;
    @BindView(R.id.scrollView_child)
    ScrollView scrollView_signup_four_everything;

    FragmentManager fragmentManager;

    ArrayList<String> tempStorage;

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

        numberpicker_age.setMinValue(19);
        numberpicker_age.setMaxValue(35);

        numberpicker_grade.setMinValue(1);
        numberpicker_grade.setMaxValue(4);
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: ");
        super.onResume();

        fragmentManager = getSupportFragmentManager();
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

        Fragment fragment = new LoadingWaitingFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction()
                .replace(R.id.frameLayout_of_signup_four, fragment)
                .addToBackStack("loading_waiting_fragment");
        transaction.commit();
        scrollView_signup_four_everything.setVisibility(View.GONE);

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

                String.valueOf(numberpicker_age.getValue()),
                String.valueOf(numberpicker_grade.getValue()),
                ((RadioButton) radiogroup_cleanness.getChildAt(radiogroup_cleanness.indexOfChild(
                        radiogroup_cleanness.findViewById(radiogroup_cleanness.getCheckedRadioButtonId())))).getText().toString(),
                ((RadioButton) radiogroup_nightfood.getChildAt(radiogroup_nightfood.indexOfChild(
                        radiogroup_nightfood.findViewById(radiogroup_nightfood.getCheckedRadioButtonId())))).getText().toString(),
                ((RadioButton) radiogroup_activity.getChildAt(radiogroup_activity.indexOfChild(
                        radiogroup_activity.findViewById(radiogroup_activity.getCheckedRadioButtonId())))).getText().toString(),
                ((RadioButton) radiogroup_alcohol_frequency.getChildAt(radiogroup_alcohol_frequency.indexOfChild(
                        radiogroup_alcohol_frequency.findViewById(radiogroup_alcohol_frequency.getCheckedRadioButtonId())))).getText().toString(),
                ((RadioButton) radiogroup_max_alcohol.getChildAt(radiogroup_max_alcohol.indexOfChild(
                        radiogroup_max_alcohol.findViewById(radiogroup_max_alcohol.getCheckedRadioButtonId())))).getText().toString(),
                ((RadioButton) radiogroup_smoking.getChildAt(radiogroup_smoking.indexOfChild(
                        radiogroup_smoking.findViewById(radiogroup_smoking.getCheckedRadioButtonId())))).getText().toString(),
                ((RadioButton) radiogroup_friend_coming_opposite.getChildAt(radiogroup_friend_coming_opposite.indexOfChild(
                        radiogroup_friend_coming_opposite.findViewById(radiogroup_friend_coming_opposite.getCheckedRadioButtonId())))).getText().toString()
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

        scrollView_signup_four_everything.setVisibility(View.VISIBLE);
        fragmentManager.popBackStack();

        Intent intent = new Intent(this, AfterSignupFinishActivity.class);
        startActivity(intent);

    }

    private void setIsRegisterFinished(boolean isRegisterFinished) {
        this.isRegisterFinished = isRegisterFinished;
    }

}

//            while (code != 200) {
//                try {
//                    Response<List<SignupFourData>> response = call.clone().execute();
//                    code = response.code();
//                } catch (IOException e) {
//                    Log.d(TAG, "ERROR!! beginFinishProcess: ");
//                    e.printStackTrace();
//                }
//            }

//                            String.valueOf(numberpicker_age.getValue()),
//                            String.valueOf(numberpicker_grade.getValue()),
//                            ((RadioButton) radiogroup_cleanness.getChildAt(radiogroup_cleanness.indexOfChild(
//                            radiogroup_cleanness.findViewById(radiogroup_cleanness.getCheckedRadioButtonId())))).getText().toString(),
//                            ((RadioButton) radiogroup_nightfood.getChildAt(radiogroup_nightfood.indexOfChild(
//                            radiogroup_nightfood.findViewById(radiogroup_nightfood.getCheckedRadioButtonId())))).getText().toString(),
//                            ((RadioButton) radiogroup_activity.getChildAt(radiogroup_activity.indexOfChild(
//                            radiogroup_activity.findViewById(radiogroup_activity.getCheckedRadioButtonId())))).getText().toString(),
//                            ((RadioButton) radiogroup_max_alcohol.getChildAt(radiogroup_max_alcohol.indexOfChild(
//                            radiogroup_max_alcohol.findViewById(radiogroup_max_alcohol.getCheckedRadioButtonId())))).getText().toString(),
//                            ((RadioButton) radiogroup_alcohol_frequency.getChildAt(radiogroup_alcohol_frequency.indexOfChild(
//                            radiogroup_alcohol_frequency.findViewById(radiogroup_alcohol_frequency.getCheckedRadioButtonId())))).getText().toString(),
//                            ((RadioButton) radiogroup_smoking.getChildAt(radiogroup_smoking.indexOfChild(
//                            radiogroup_smoking.findViewById(radiogroup_smoking.getCheckedRadioButtonId())))).getText().toString(),
//                            ((RadioButton) radiogroup_friend_coming_opposite.getChildAt(radiogroup_friend_coming_opposite.indexOfChild(
//                            radiogroup_friend_coming_opposite.findViewById(radiogroup_friend_coming_opposite.getCheckedRadioButtonId())))).getText().toString()



//        registerDataThread = new RegisterSingupData("thread_to_register_data");
//        registerDataThread.start();
//        Handler registerDataHandler = new Handler(registerDataThread.getLooper()){
//            @Override
//            public void handleMessage(Message msg) {
//                Log.d(TAG, "handleMessage: ");
//                super.handleMessage(msg);
//            }
//        };
//        registerDataHandler.post(registerDataThread);


/*
 *  Task : Runnable
 *
 *  Register all the Information of which is inserted by User
 *  to the Server by REST API 'POST' request.
 *  After getting 200 (OK) response from the server
 *  this application keeps going.
 */
//public class RegisterSingupData extends HandlerThread {
//
//    private final String TAG = "RegisterSingupData";
//
//    public RegisterSingupData(String name) {
//        super(name);
//    }
//
//    public RegisterSingupData(String name, int priority) {
//        super(name, priority);
//    }
//
//    @Override
//    public void run() {
//        Log.d(TAG, "run: ");
//
//        int list_length = getIntent().getIntExtra(StaticVarMethods.mCharacterListLength, -1);
//        if (list_length != -1) {
//            for (int i=0; i < list_length; ++i) {
//                tempStorage.add(getIntent().getStringExtra(String.valueOf(i)));
//            }
//
//        }
//        InsertMatchAllService service = RetrofitClientInstance.getRetrofitInstance().create(InsertMatchAllService.class);
//        Call<List<DataAllMatch>> call = service.insertAllMatchData(
//                getIntent().getStringExtra(StaticVarMethods.mGENDER),
//                getIntent().getStringExtra(StaticVarMethods.mAGE),
//                getIntent().getStringExtra(StaticVarMethods.mGRADE),
//                getIntent().getStringExtra(StaticVarMethods.mCLEAN),
//                getIntent().getStringExtra(StaticVarMethods.mYASIK),
//                tempStorage,
//                getIntent().getStringExtra(StaticVarMethods.mACTIVITY),
//                getIntent().getStringExtra(StaticVarMethods.mFREQ_DRINK),
//                getIntent().getStringExtra(StaticVarMethods.mDRINK),
//                getIntent().getStringExtra(StaticVarMethods.mSMOKE),
//
//                String.valueOf(numberpicker_age.getValue()),
//                String.valueOf(numberpicker_grade.getValue()),
//                ((RadioButton) radiogroup_cleanness.getChildAt(radiogroup_cleanness.indexOfChild(
//                        radiogroup_cleanness.findViewById(radiogroup_cleanness.getCheckedRadioButtonId())))).getText().toString(),
//                ((RadioButton) radiogroup_nightfood.getChildAt(radiogroup_nightfood.indexOfChild(
//                        radiogroup_nightfood.findViewById(radiogroup_nightfood.getCheckedRadioButtonId())))).getText().toString(),
//                ((RadioButton) radiogroup_activity.getChildAt(radiogroup_activity.indexOfChild(
//                        radiogroup_activity.findViewById(radiogroup_activity.getCheckedRadioButtonId())))).getText().toString(),
//                ((RadioButton) radiogroup_alcohol_frequency.getChildAt(radiogroup_alcohol_frequency.indexOfChild(
//                        radiogroup_alcohol_frequency.findViewById(radiogroup_alcohol_frequency.getCheckedRadioButtonId())))).getText().toString(),
//                ((RadioButton) radiogroup_max_alcohol.getChildAt(radiogroup_max_alcohol.indexOfChild(
//                        radiogroup_max_alcohol.findViewById(radiogroup_max_alcohol.getCheckedRadioButtonId())))).getText().toString(),
//                ((RadioButton) radiogroup_smoking.getChildAt(radiogroup_smoking.indexOfChild(
//                        radiogroup_smoking.findViewById(radiogroup_smoking.getCheckedRadioButtonId())))).getText().toString(),
//                ((RadioButton) radiogroup_friend_coming_opposite.getChildAt(radiogroup_friend_coming_opposite.indexOfChild(
//                        radiogroup_friend_coming_opposite.findViewById(radiogroup_friend_coming_opposite.getCheckedRadioButtonId())))).getText().toString()
//        );
//
//        setIsRegisterFinished(true);
//
//    }
//
//
//
//    @Override
//    public boolean quitSafely() {
//        Log.d(TAG, "quitSafely: ");
//        return super.quitSafely();
//    }
//}
