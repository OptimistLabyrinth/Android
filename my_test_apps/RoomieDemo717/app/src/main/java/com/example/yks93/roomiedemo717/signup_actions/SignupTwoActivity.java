package com.example.yks93.roomiedemo717.signup_actions;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

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

public class SignupTwoActivity extends AppCompatActivity{

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

            TextView tvTemp1 = new TextView(this), tvTemp2 = new TextView(this);
            tvTemp1.setText(R.string.there_is_empty_placeholder);
            tvTemp2.setText(R.string.OK_button);

            builder.setMessage(tvTemp1.getText().toString())
                    .setPositiveButton(tvTemp2.getText().toString(), (d, w) -> { ; });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
        else {
            SendSignupTwoService service = RetrofitClientInstance.getRetrofitInstance().create(SendSignupTwoService.class);
            Call<List<SignupTwoData>> call = service.sendSingupTwoData(
                    edittext_user_name.getText().toString(),
                    edittext_user_phone.getText().toString(),
                    edittext_user_email.getText().toString(),
                    edittext_user_stuid.getText().toString(),
                    edittext_user_major.getText().toString()
            );

            call.enqueue(new Callback<List<SignupTwoData>>() {
                @Override
                public void onResponse(Call<List<SignupTwoData>> call, Response<List<SignupTwoData>> response) {
                    Log.d(TAG, "onResponse: ");
                    int code = response.code();

                    if (code != 200)
                        this.onFailure(call, new Throwable());
                }

                @Override
                public void onFailure(Call<List<SignupTwoData>> call, Throwable t) {
                    Log.d(TAG, "onFailure: RETRYING");
                    call.clone().enqueue(this);
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
