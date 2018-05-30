package com.example.yks93.roomiedemo717.signup_actions;

import com.google.gson.annotations.SerializedName;

public class SignupOneData {

    @SerializedName("ID")
    private String id;
    @SerializedName("PWD")
    private String pwd;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}
