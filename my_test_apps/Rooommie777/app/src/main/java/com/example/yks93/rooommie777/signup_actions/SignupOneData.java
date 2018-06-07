package com.example.yks93.rooommie777.signup_actions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/*
 *  Depreciated
 */
@Deprecated
public class SignupOneData {

    @Expose
    @SerializedName("ID")
    private String id;
    @Expose
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
