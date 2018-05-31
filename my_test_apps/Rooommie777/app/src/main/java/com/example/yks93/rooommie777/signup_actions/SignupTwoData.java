package com.example.yks93.rooommie777.signup_actions;

import com.google.gson.annotations.SerializedName;

/*
 *  Depreciated
 */
public class SignupTwoData {

    @SerializedName("NAME")
    private String name;
    @SerializedName("PHONE")
    private String phone;
    @SerializedName("EMAIL")
    private String email;
    @SerializedName("STUD_ID")
    private String stud_id;
    @SerializedName("MAJOR")
    private String major;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getStud_id() {
        return stud_id;
    }
    public void setStud_id(String stud_id) {
        this.stud_id = stud_id;
    }

    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }

}
