package com.example.yks93.roomiedemo717.trylogin;

import com.google.gson.annotations.SerializedName;

public class LoginData {

    @SerializedName("ID")
    private String id;
    @SerializedName("PWD")
    private String pwd;

    public LoginData (String id, String pwd) {
        this.id = id;
        this.pwd = pwd;
    }

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
