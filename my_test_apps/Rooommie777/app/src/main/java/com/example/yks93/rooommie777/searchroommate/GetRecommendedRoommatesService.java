package com.example.yks93.rooommie777.searchroommate;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetRecommendedRoommatesService {

    @GET("/recommend")
    Call<List<DataRoommate>> readRoommateInfo(
            @Query("STUD_ID") String stud_id,
            @Query("OP_STUD_ID") String op_stud_id,
            @Query("OP_NAME") String name,
            @Query("OP_AGE") String age,
            @Query("OP_MAJOR") String major,
            @Query("OP_PHONE") String phone,
            @Query("OP_GRADE") String grade,
            @Query("OP_CLEAN") String clena,
            @Query("OP_YASIK") String yasik,
            @Query("OP_CHARACTER") String character,
            @Query("OP_OUTSIDE_ACTIVITY") String activity,
            @Query("OP_FREQ_DRINK") String freqDrink,
            @Query("OP_DRINK") String drink,
            @Query("OP_SMOKE") String smoke
    );

}
