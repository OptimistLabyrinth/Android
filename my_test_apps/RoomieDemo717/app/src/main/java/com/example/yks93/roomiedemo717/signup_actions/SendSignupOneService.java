package com.example.yks93.roomiedemo717.signup_actions;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SendSignupOneService {

    @FormUrlEncoded
    @POST("/insertSignupOne")
    Call<List<SignupOneData>> sendSignupOneData(
            @Field("ID") String id,
            @Field("PWD") String pwd
    );

}
