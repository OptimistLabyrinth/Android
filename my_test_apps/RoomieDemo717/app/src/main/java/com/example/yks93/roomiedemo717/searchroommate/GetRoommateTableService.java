package com.example.yks93.roomiedemo717.searchroommate;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/*
 *  Depreciated
 */
public interface GetRoommateTableService {

    @GET("/member")
    Call<List<RoommateData>> getMatchingData(
            @Query("STUD_ID") String stud_id,
            @Query("ID") String id,
            @Query("PWD") String pwd,
            @Query("NAME") String name,
            @Query("GENDER") String gender,
            @Query("PHONE") String phone,
            @Query("EMAIL") String email,
            @Query("MAJOR") String major
    );

}
