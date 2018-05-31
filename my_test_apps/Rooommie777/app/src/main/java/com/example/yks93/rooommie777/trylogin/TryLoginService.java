package com.example.yks93.rooommie777.trylogin;

import com.example.yks93.rooommie777.signup_actions.SignupOneData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TryLoginService {

    @GET("/trylogin")
    Call<List<SignupOneData>> tryLoginNow(
            @Query("ID") String id,
            @Query("PWD") String pwd
    );

}
