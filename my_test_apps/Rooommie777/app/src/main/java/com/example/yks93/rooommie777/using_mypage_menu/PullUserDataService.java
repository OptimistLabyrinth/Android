package com.example.yks93.rooommie777.using_mypage_menu;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PullUserDataService {

    @GET("/mypage")
    Call<List<DataforMypage>> pullUserData(
            @Query("STUD_ID") String stud_id,
            @Query("NAME") String name,
            @Query("GENDER") String gender,
            @Query("PHONE") String phone,
            @Query("EMAIL") String email,
            @Query("MAJOR") String major,


            @Query("MY_AGE") String my_age,
            @Query("MY_GRADE") String my_grade,
            @Query("MY_CLEAN") String my_clean,
            @Query("MY_YASIK") String my_yasik,
            @Query("MY_CHARACTER") String my_character,
            @Query("MY_OUTSIDE_ACTIVITY") String my_activity,
            @Query("MY_FREQ_DRINK") String my_freq_drink,
            @Query("MY_DRINK") String my_drink,
            @Query("MY_SMOKE") String my_smoke,


            @Query("OP_AGE") String op_age,
            @Query("OP_GRADE") String op_grade,
            @Query("OP_CLEAN") String op_clean,
            @Query("OP_YASIK") String op_yasik,
            @Query("OP_OUTSIDE_ACTIVITY") String op_activity,
            @Query("OP_FREQ_DRINK") String op_freq_drink,
            @Query("OP_DRINK") String op_drink,
            @Query("OP_SMOKE") String op_smoke,
            @Query("AGREE_WITH") String agree_with
    );

}
