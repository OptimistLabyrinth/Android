package com.example.yks93.rooommie777.loading_waiting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yks93.rooommie777.R;
import com.example.yks93.rooommie777.retrofit_package.RetrofitClientInstance;
import com.example.yks93.rooommie777.signup_actions.DataAllMatch;
import com.example.yks93.rooommie777.signup_actions.InsertMatchAllService;
import com.example.yks93.rooommie777.static_storage.StaticVarMethods;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoadingWaitingActivityAfterSignupFour extends AppCompatActivity implements TextWatcher {

    @BindView(R.id.tv_loading_wainting_1)
    TextView tv1;
    @BindView(R.id.tv_loading_wainting_2)
    TextView tv2;
    @BindView(R.id.progressBar_loading_waiting)
    ProgressBar progressBar;
    @BindView(R.id.tv_temp_loading_waiting_after_signup_four)
    TextView tv_temp;

    ArrayList<String> tempStorage = new ArrayList<>();

    private final String TAG = "LoadingWaitingAfterSign";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_waiting_after_signup_four);
        ButterKnife.bind(this);

        tv_temp.addTextChangedListener(this);

        Bundle bundle = getIntent().getBundleExtra(StaticVarMethods.mCHARACTER);
        int list_length = bundle.getInt(StaticVarMethods.mCharacterListLength);
        for (int i=0; i < list_length; ++i) {
            tempStorage.add(bundle.getString(String.valueOf(i)));
        }

    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: ");
        super.onResume();

        InsertMatchAllService service = RetrofitClientInstance.getRetrofitInstance().create(InsertMatchAllService.class);
        Call<List<DataAllMatch>> call = service.insertAllMatchData(
                getIntent().getStringExtra(StaticVarMethods.STUD_ID),

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

                getIntent().getStringExtra(StaticVarMethods.opAGE),
                getIntent().getStringExtra(StaticVarMethods.opGRADE),
                getIntent().getStringExtra(StaticVarMethods.opCLEAN),
                getIntent().getStringExtra(StaticVarMethods.opYASIK),
                getIntent().getStringExtra(StaticVarMethods.opACTIVITY),
                getIntent().getStringExtra(StaticVarMethods.opFREQ_DRINK),
                getIntent().getStringExtra(StaticVarMethods.opDRINK),
                getIntent().getStringExtra(StaticVarMethods.opSMOKE),
                getIntent().getStringExtra(StaticVarMethods.AGREE_WITH)
        );

        call.enqueue(new Callback<List<DataAllMatch>>() {
            @Override
            public void onResponse(Call<List<DataAllMatch>> call, Response<List<DataAllMatch>> response) {
                int code = response.code();
                Log.d(TAG, "onResponse: code = " + code);

                if (code == 200) {
//                    tv_temp.setText(code);
                    Toast.makeText(LoadingWaitingActivityAfterSignupFour.this, R.string.OK_button, Toast.LENGTH_SHORT).show();
                    finish();
                }
            }

            @Override
            public void onFailure(Call<List<DataAllMatch>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.toString());
            }

        });

        Toast.makeText(this, R.string.OK_button, Toast.LENGTH_SHORT).show();
        finish();
    }

    @OnClick({R.id.tv_loading_wainting_1, R.id.tv_loading_wainting_2, R.id.progressBar_loading_waiting})
    void onClickAnywhere() {
        Toast.makeText(this, R.string.plz_wait, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Toast.makeText(this, R.string.OK_button, Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
