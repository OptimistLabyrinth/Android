package com.example.yks93.roomiedemo717.signup_actions;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

/*
 *  Depreciated
 */
public interface SendSignupTwoService {

    @POST("/insertSingupAll")
    Call<List<SignupTwoData>> sendSingupTwoData(
            @Query("NAME") String name,
            @Query("PHONE") String phone,
            @Query("EMAIL") String email,
            @Query("STUD_ID") String stud_id,
            @Query("MAJOR") String major
    );

}
