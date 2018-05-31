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
public interface SendSignupThreeService {

    @POST("/insertSignupThree")
    Call<List<SignupThreeData>> sendSignupThreeData(
            @Query("MY_GENDER") String gender,
            @Query("MY_AGE") String age,
            @Query("MY_GRADE") String grade,
            @Query("MY_CHARACTER") List<String> character,
            @Query("MY_CLEAN") String clean,
            @Query("MY_YASIK") String yasik,
            @Query("MY_OUTSIDE_ACTIVITY") String outside_activity,
            @Query("MY_DRINK") String drink,
            @Query("MY_FREQ_DRINK") String freq_drink,
            @Query("MY_SMOKE") String smoke
    );

}
