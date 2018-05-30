package com.example.yks93.roomiedemo717.signup_actions;

import com.google.gson.annotations.SerializedName;

public class SignupTwoData {

    @SerializedName("Name")
    private String name;
    @SerializedName("Phone")
    private String phone;
    @SerializedName("Email")
    private String email;
    @SerializedName("Stud_ID")
    private String stud_id;
    @SerializedName("Major")
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
