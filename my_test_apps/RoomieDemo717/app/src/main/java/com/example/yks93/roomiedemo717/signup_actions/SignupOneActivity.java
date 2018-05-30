package com.example.yks93.roomiedemo717.signup_actions;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
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

public class SignupOneActivity extends AppCompatActivity implements TextWatcher {

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

    ArrayList<String> UserIDList = new ArrayList();
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
                for (IDdata iddata : tmp)
                    UserIDList.add(iddata.getId());
            }

            @Override
            public void onFailure(Call<List<IDdata>> call, Throwable t) {
                Log.d(TAG, "onFailure: + " + t.toString());
                call.clone().enqueue(this);
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
                String id_value = edittext_id_input_from_user.getText().toString();
                String pwd_value = edittext_pwd_input_from_user.getText().toString();
                int code = 0;

                SendSignupOneService service = RetrofitClientInstance.getRetrofitInstance().create(SendSignupOneService.class);
                Call<List<SignupOneData>> call = service.sendSignupOneData(
                        id_value,
                        pwd_value
                );

                call.enqueue(new Callback<List<SignupOneData>>() {
                    @Override
                    public void onResponse(Call<List<SignupOneData>> call, Response<List<SignupOneData>> response) {
                        Log.d(TAG, "onResponse: ");
                        int code = response.code();

                        if (code != 200)
                            this.onFailure(call, new Throwable());
                    }

                    @Override
                    public void onFailure(Call<List<SignupOneData>> call, Throwable t) {
                        Log.d(TAG, "onFailure: RETRYING");
                        call.clone().enqueue(this);
                    }
                });

                Intent intent = new Intent(this, SignupTwoActivity.class);
                startActivity(intent);

            }
        }
        else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            TextView tvTemp1 = new TextView(this), tvTemp2 = new TextView(this);
            tvTemp1.setText(R.string.cannot_move_to_signup_two_message);
            tvTemp2.setText(R.string.OK_button);

            builder.setMessage(tvTemp1.getText().toString())
                    .setPositiveButton(tvTemp2.getText().toString(), (d, w) -> { ; });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }


    }

    private void openIDReplicatedDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        TextView tvTemp1 = new TextView(this), tvTemp2 = new TextView(this);
        tvTemp1.setText(R.string.id_replicated_message);
        tvTemp2.setText(R.string.OK_button);

        builder.setMessage(tvTemp1.getText().toString())
                .setPositiveButton(tvTemp2.getText().toString(), (d, w) -> { ; });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void openIDUsableDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        TextView tvTemp1 = new TextView(this), tvTemp2 = new TextView(this);
        tvTemp1.setText(R.string.id_usable_message);
        tvTemp2.setText(R.string.OK_button);

        builder.setMessage(tvTemp1.getText().toString())
                .setPositiveButton(tvTemp2.getText().toString(), (d, w) -> { ; });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void requestIDReplicateCheckDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        TextView tvTemp1 = new TextView(this), tvTemp2 = new TextView(this);
        tvTemp1.setText(R.string.id_haveto_duplicate_check_message);
        tvTemp2.setText(R.string.OK_button);

        builder.setMessage(tvTemp1.getText().toString())
                .setPositiveButton(tvTemp2.getText().toString(), (d, w) -> { ; });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private boolean checkPWDConfirmed() {
        if (edittext_pwd_input_from_user.getText().toString()
                .equals(edittext_pwd_input_again_from_user.getText().toString()))
            isPWDconfirmed = true;

        return isPWDconfirmed;
    }

    private void openPWDInappropriate() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        TextView tvTemp1 = new TextView(this), tvTemp2 = new TextView(this);
        tvTemp1.setText(R.string.pwd_inappropriate_message);
        tvTemp2.setText(R.string.OK_button);

        builder.setMessage(tvTemp1.getText().toString())
                .setPositiveButton(tvTemp2.getText().toString(), (d, w) -> { ; });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
