package com.example.yks93.myapptest003;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataClass {

    @Expose
    @SerializedName("msg")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
