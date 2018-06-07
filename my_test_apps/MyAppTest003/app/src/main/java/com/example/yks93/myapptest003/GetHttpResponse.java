package com.example.yks93.myapptest003;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetHttpResponse {

    @GET("/")
    Call<DataClass> onResponse();

}
