package com.example.yks93.roomiedemo717.signup_actions;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SendSignupFourService {

    @FormUrlEncoded
    @POST("/insertSignupFour")
    Call<List<SignupFourData>> sendSignupFourData(
            @Field("age") String age,
            @Field("grade") String grade,
            @Field("personality") List<String> personality,
            @Field("cleanness") String cleanness,
            @Field("nightfood") String nightfood,
            @Field("outsideActivity") String outsideActivity,
            @Field("maxAlcohol") String maxAlcohol,
            @Field("alcoholFreq") String alcoholFrequency,
            @Field("smoking") String smoking,
            @Field("friendComing") String friendComing
    );

}
