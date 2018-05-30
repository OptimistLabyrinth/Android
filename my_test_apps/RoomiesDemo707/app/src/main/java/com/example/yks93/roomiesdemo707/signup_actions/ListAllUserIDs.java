package com.example.yks93.roomiesdemo707.signup_actions;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Streaming;

public interface ListAllUserIDs {

    @GET("/ListAllUserIDs")
    @Streaming
    Call<List<IDdata>> listAllUserIDs();

}
