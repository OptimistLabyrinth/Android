package com.example.yks93.mysocketpractice02;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetResultService {

    @GET("/result")
    Call<List<RetroNumberData>> getBalanceResult(
            @Query("balance") String balance,
            @Query("amount") String amount,
            @Query("depositOrWithdraw") String depositOrWithdraw
    );

}
