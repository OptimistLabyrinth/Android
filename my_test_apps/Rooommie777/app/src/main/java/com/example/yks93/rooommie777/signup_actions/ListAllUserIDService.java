package com.example.yks93.rooommie777.signup_actions;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ListAllUserIDService {

    @GET("/ListAllUserIDs")
    Call<List<IDdata>> listAllUserIDs();

}
