package com.example.yks93.roomiesdemo707.signup_actions;

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
import android.widget.TextView;

import com.example.yks93.roomiesdemo707.R;
import com.example.yks93.roomiesdemo707.retrofit_package.RetrofitClientInstance;

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

        ListAllUserIDs listIDs = RetrofitClientInstance.getRetrofitInstance().create(ListAllUserIDs.class);
        Call<List<IDdata>> call = listIDs.listAllUserIDs();

        Log.d(TAG, "getAllUserIDsFromDatabase: initialization...");

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
                Log.d(TAG, "onFailure: ");
            }
        });
    }

    @OnClick(R.id.btn_id_input_from_user)
    void onIdReplicationCheckButtonClicked() {
        Log.d(TAG, "onIDReplicationCheckButtonClicked: ");
        if (UserIDList.contains(btn_id_input_from_user.getText().toString())) {
            openIDReplicatedDialog();
            isIDusable = false;
        }
        else {
            openIDUsable();
            isIDusable = true;
        }
    }

    @OnClick(R.id.btn_move_to_signup_two)
    void onMoveToSignupTwoButtonClicked() {
        Log.d(TAG, "onMoveToSignupTwoButtonClicked: ");
        if (!checkPWDConfirmed()) {
            openPWDInappropriate();
        }
        else {
            Intent intent = new Intent(this, SignupTwoActivity.class);
            intent.putExtra("ID", edittext_id_input_from_user.getText().toString());
            intent.putExtra("PWD", edittext_pwd_input_from_user.getText().toString());
            startActivity(intent);
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

    private void openIDUsable() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        TextView tvTemp1 = new TextView(this), tvTemp2 = new TextView(this);
        tvTemp1.setText(R.string.id_usable_message);
        tvTemp2.setText(R.string.OK_button);

        builder.setMessage(tvTemp1.getText().toString())
                .setPositiveButton(tvTemp2.getText().toString(), (d, w) -> { ; });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private boolean checkPWDConfirmed() {
        if (edittext_pwd_input_from_user.getText().toString() ==
                edittext_pwd_input_again_from_user.getText().toString())
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

}
