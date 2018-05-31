package com.example.yks93.rooommie777.signup_actions;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/*
 *  Depreciated
 */
public interface SendSignupFourService {

    @GET("/insertSignupFour")
    Call<List<SignupFourData>> sendSignupFourData(
            @Query("OP_AGE") String age,
            @Query("OP_GRADE") String grade,
            @Query("OP_CLEAN") String clean,
            @Query("OP_YASIK") String yasik,
            @Query("OP_OUTSIDE_ACTIVITY") String outside_activity,
            @Query("OP_DRINK") String drink,
            @Query("OP_FREQ_DRINK") String freq_drink,
            @Query("OP_SMOKE") String smoke,
            @Query("AGREE_WITH") String agree_with
    );

}
