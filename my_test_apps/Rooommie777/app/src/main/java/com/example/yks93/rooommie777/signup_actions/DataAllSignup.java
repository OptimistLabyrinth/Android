package com.example.yks93.rooommie777.signup_actions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataAllSignup {

/*
 *
 */
    @Expose
    @SerializedName("STUD_ID")
    private String stud_id;
    @Expose
    @SerializedName("ID")
    private String id;
    @Expose
    @SerializedName("PWD")
    private String pwd;
    @Expose
    @SerializedName("NAME")
    private String name;
    @Expose
    @SerializedName("GENDER")
    private String gender;
    @Expose
    @SerializedName("PHONE")
    private String phone;
    @Expose
    @SerializedName("EMAIL")
    private String email;
    @Expose
    @SerializedName("MAJOR")
    private String major;
/*
 *
 */
    public String getStud_id() {
        return stud_id;
    }

    public void setStud_id(String stud_id) {
        this.stud_id = stud_id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
/*
 *
 */
}
