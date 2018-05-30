package com.example.yks93.roomiedemo717.signup_actions;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SendSignupTwoService {

    @FormUrlEncoded
    @POST("/insertSingupTwo")
    Call<List<SignupTwoData>> sendSingupTwoData(
            @Field("Name") String name,
            @Field("Phone") String phone,
            @Field("Email") String email,
            @Field("Stud_ID") String stud_id,
            @Field("Major") String major
    );

}
