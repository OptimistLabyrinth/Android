package com.example.yks93.roomiesdemo707.signup_actions;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

public class IDdata {

    private final String TAG = "IDdata";

    @SerializedName("id")
    private String id;

    public String getId() {
        Log.d(TAG, "getId: ");
        return id;
    }

    public void setId(String id) {
        this.id = id;
        Log.d(TAG, "setId: ");
    }

}
