package com.example.yks93.rooommie777.signup_actions;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/*
 *  Depreciated
 */
public interface SendSignupOneService {


    @GET("/insertSignup")
    Call<List<SignupOneData>> sendSignupOneData(
            @Query(value = "ID") String id,
            @Query(value = "PWD") String pwd
    );

}
