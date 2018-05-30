package com.example.yks93.roomiedemo717.signup_actions;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Streaming;

public interface ListAllUserIDService {

    @GET("/ListAllUserIDs")
    @Streaming
    Call<List<IDdata>> listAllUserIDs();

}
