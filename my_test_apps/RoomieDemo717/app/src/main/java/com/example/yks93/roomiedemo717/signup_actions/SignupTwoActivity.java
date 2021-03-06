package com.example.yks93.roomiedemo717.signup_actions;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

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

public class SignupTwoActivity extends AppCompatActivity{

    @BindView(R.id.radiogroup_gender_signup_two)
    RadioGroup radioGroup_gender;
    @BindView(R.id.edittext_user_name)
    EditText edittext_user_name;
    @BindView(R.id.edittext_user_phone)
    EditText edittext_user_phone;
    @BindView(R.id.edittext_user_email)
    EditText edittext_user_email;
    @BindView(R.id.edittext_user_stuid)
    EditText edittext_user_stuid;
    @BindView(R.id.edittext_user_major)
    EditText edittext_user_major;

    private final String TAG = "SignupTwoActivity";
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_two);
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

    @OnClick(R.id.btn_move_to_signup_three)
    void onMoveToSignupThreeButtonClicked() {
        Log.d(TAG, "onMoveToSignupThreeButtonClicked: ");

        if (!ifNoneEmptyString()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setMessage(R.string.there_is_empty_placeholder)
                    .setPositiveButton(R.string.OK_button, (d, w) -> { ; });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
        else {
            InsertSignupAllService service = RetrofitClientInstance.getRetrofitInstance().create(InsertSignupAllService.class);
            Call<List<DataAllSignup>> call = service.insertAllSignupData(
                    edittext_user_stuid.getText().toString(),
                    getIntent().getStringExtra(StaticVarMethods.USER_ID),
                    getIntent().getStringExtra(StaticVarMethods.USER_PWD),
                    edittext_user_name.getText().toString(),
                    ((RadioButton) radioGroup_gender.getChildAt(radioGroup_gender.indexOfChild(
                            radioGroup_gender.findViewById(radioGroup_gender.getCheckedRadioButtonId())))).getText().toString(),
                    edittext_user_phone.getText().toString(),
                    edittext_user_email.getText().toString(),
                    edittext_user_major.getText().toString()
            );

            call.enqueue(new Callback<List<DataAllSignup>>() {
                @Override
                public void onResponse(Call<List<DataAllSignup>> call, Response<List<DataAllSignup>> response) {
                    Log.d(TAG, "onResponse: ");
                    int code = response.code();
                    Log.d(TAG, "onResponse: code = " + code);
                }

                @Override
                public void onFailure(Call<List<DataAllSignup>> call, Throwable t) {
                    Log.d(TAG, "onFailure: ");
                }
            });

            Intent intent = new Intent(this, SignupThreeActivity.class);
            startActivity(intent);

        }

    }

    private boolean ifNoneEmptyString() {
        ArrayList<EditText> arrayList = new ArrayList<>();
        arrayList.add(edittext_user_name);
        arrayList.add(edittext_user_phone);
        arrayList.add(edittext_user_email);
        arrayList.add(edittext_user_stuid);
        arrayList.add(edittext_user_major);

        for (EditText et : arrayList) {
            if (et.getText().toString().equals(""))
                return false;
        }
        return true;
    }
    
}
