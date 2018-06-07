package com.example.yks93.rooommie777.signup_actions;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.example.yks93.rooommie777.R;
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

public class SignupOneActivity extends AppCompatActivity {

    @BindView(R.id.edittext_id_input_from_user)
    EditText edittext_id_input_from_user;
    @BindView(R.id.btn_id_input_from_user)
    Button btn_id_input_from_user;
    @BindView(R.id.edittext_pwd_input_from_user)
    EditText edittext_pwd_input_from_user;
    @BindView(R.id.edittext_pwd_input_again_from_user)
    EditText edittext_pwd_input_again_from_user;
    @BindView(R.id.btn_move_to_signup_two)
    Button btn_move_to_signup_two;

    @BindView(R.id.frameLayout_one)
    FrameLayout fragment_location;

    ArrayList<String> UserIDList = new ArrayList<>();
    boolean isIDusable = false;
    boolean isPWDconfirmed = false;

    private final String TAG = "SignupOneActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_signup_one);
        ButterKnife.bind(this);

        getAllUserIDsFromDatabase();
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

    private void getAllUserIDsFromDatabase() {
        Log.d(TAG, "getAllUserIDsFromDatabase: ");

        ListAllUserIDService listIDs = RetrofitClientInstance.getRetrofitInstance().create(ListAllUserIDService.class);
        Call<List<IDdata>> call = listIDs.listAllUserIDs();

        Log.d(TAG, "getAllUserIDsFromDatabase:  passing parameter...");

        call.enqueue(new Callback<List<IDdata>>() {

            @Override
            public void onResponse(Call<List<IDdata>> call, Response<List<IDdata>> response) {
                Log.d(TAG, "onResponse: ");
                ArrayList<IDdata> tmp =(ArrayList<IDdata>) response.body();
                if (response.code() == 200) {
                    for (IDdata iddata : tmp)
                        UserIDList.add(iddata.getId());
                }
            }

            @Override
            public void onFailure(Call<List<IDdata>> call, Throwable t) {
                Log.d(TAG, "onFailure: + " + t.toString());
//                call.clone().enqueue(this);
            }
        });
    }

    @OnClick(R.id.btn_id_input_from_user)
    void onIdReplicationCheckButtonClicked() {
        Log.d(TAG, "onIDReplicationCheckButtonClicked: ");
        if (!edittext_id_input_from_user.getText().toString().equals("") &&
                UserIDList.contains(btn_id_input_from_user.getText().toString())) {
            openIDReplicatedDialog();
            isIDusable = false;
        }
        else {
            openIDUsableDialog();
            isIDusable = true;
        }
    }

    @OnClick(R.id.btn_move_to_signup_two)
    void onMoveToSignupTwoButtonClicked() {
        Log.d(TAG, "onMoveToSignupTwoButtonClicked: ");

        if (!edittext_id_input_from_user.getText().toString().equals("") &&
                !edittext_pwd_input_from_user.getText().toString().equals("") &&
                !edittext_pwd_input_again_from_user.getText().toString().equals("")) {
            if (!isIDusable) {
                requestIDReplicateCheckDialog();
            }
            else if (!checkPWDConfirmed()) {
                openPWDInappropriate();
            }
            else {
                Intent intent = new Intent(this, SignupTwoActivity.class);

                intent.putExtra(StaticVarMethods.USER_ID,
                        edittext_id_input_from_user.getText().toString());
                intent.putExtra(StaticVarMethods.USER_PWD,
                        edittext_pwd_input_from_user.getText().toString());

                startActivity(intent);

            }
        }
        else {
            new AlertDialog.Builder(this)
                    .setMessage(R.string.cannot_move_to_signup_two_message)
                    .setPositiveButton(R.string.OK_button, (d, w) -> { ; })
                    .create().show();
        }


    }

    private void openIDReplicatedDialog() {
        new AlertDialog.Builder(this)
                .setMessage(R.string.id_replicated_message)
                .setPositiveButton(R.string.OK_button, (d, w) -> { ; })
                .create().show();
    }

    private void openIDUsableDialog() {
        new AlertDialog.Builder(this)
                .setMessage(R.string.id_usable_message)
                .setPositiveButton(R.string.OK_button, (d, w) -> { ; })
                .create().show();
    }

    private void requestIDReplicateCheckDialog() {
        new AlertDialog.Builder(this)
                .setMessage(R.string.id_haveto_duplicate_check_message)
                .setPositiveButton(R.string.OK_button, (d, w) -> { ; })
                .create().show();
    }

    private boolean checkPWDConfirmed() {
        if (edittext_pwd_input_from_user.getText().toString()
                .equals(edittext_pwd_input_again_from_user.getText().toString()))
            isPWDconfirmed = true;

        return isPWDconfirmed;
    }

    private void openPWDInappropriate() {
        new AlertDialog.Builder(this)
                .setMessage(R.string.pwd_inappropriate_message)
                .setPositiveButton(R.string.OK_button, (d, w) -> { ; })
                .create().show();
    }

}


//    @BindView(R.id.tv_result_id)
//    TextView tv_id;
//    @BindView(R.id.tv_result_pwd)
//    TextView tv_pwd;
//    String id_result = "";
//    String pwd_result = "";



//                String id_value = edittext_id_input_from_user.getText().toString();
//                String pwd_value = edittext_pwd_input_from_user.getText().toString();
////                int id_value = 7;
////                int pwd_value = 17;
//
//
//
//                int code = 0;
//
//                SendSignupOneService service = RetrofitClientInstance.getRetrofitInstance().create(SendSignupOneService.class);
//                Call<List<SignupOneData>> call = service.sendSignupOneData(
//                        id_value,
//                        pwd_value
//                );
//
//                call.enqueue(new Callback<List<SignupOneData>>() {
//                    @Override
//                    public void onResponse(Call<List<SignupOneData>> call, Response<List<SignupOneData>> response) {
//                        Log.d(TAG, "onResponse: ");
//                        int code = response.code();
//                        Log.d(TAG, "code: " + code);
//
////                        id_result = response.body().get(0).getId();
////                        pwd_result = response.body().get(0).getPwd();
////
////                        tv_id.setText(id_result);
////                        tv_pwd.setText(pwd_result);
//
//                        if (code != 200) {
//                            call.cancel();
//                            Log.d(TAG, "onResponse: RETRYING");
////                            this.onFailure(call, new Throwable());
//
//                        }
//                        else {
//                            Log.d(TAG, "onResponse: SUCCESS SUCCESS SUCCESS SUCCESS SUCCESS ");
//                        }
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<SignupOneData>> call, Throwable t) {
//                        Log.d(TAG, "onFailure: RETRYING");
////                        call.clone().enqueue(this);
//                    }
//                });
