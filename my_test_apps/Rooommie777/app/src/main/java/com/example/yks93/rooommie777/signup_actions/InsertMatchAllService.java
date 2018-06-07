package com.example.yks93.rooommie777.signup_actions;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface InsertMatchAllService {

    @GET("/insertMatchAll")
    Call<List<DataAllMatch>> insertAllMatchData(
            @Query("STUD_ID") String stud_id,

            @Query("MY_GENDER") String myGender,
            @Query("MY_AGE") String myAge,
            @Query("MY_GRADE") String myGrade,
            @Query("MY_CLEAN") String myClean,
            @Query("MY_YASIK") String myYasik,
            @Query("MY_CHARACTER") List<String> myCharacter,
            @Query("MY_OUTSIDE_ACTIVITY") String myOutsideActivity,
            @Query("MY_FREQ_DRINK") String myFreqDrink,
            @Query("MY_DRINK") String myDrink,
            @Query("MY_SMOKE") String mySmoke,

            @Query("OP_AGE") String opAge,
            @Query("OP_GRADE") String opGrade,
            @Query("OP_CLEAN") String opClean,
            @Query("OP_YASIK") String opYasik,
            @Query("OP_OUTSIDE_ACTIVITY") String opOutsideActivity,
            @Query("OP_FREQ_DRINK") String opFreqDrink,
            @Query("OP_DRINK") String opDrink,
            @Query("OP_SMOKE") String opSmoke,
            @Query("AGREE_WITH") String agreeWith

    );

}
