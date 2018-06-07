package com.example.yks93.rooommie777.searchroommate;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataRoommate {

    @SerializedName("STUD_ID")
    private String stud_id;
    @SerializedName("OP_STUD_ID")
    private String op_stud_id;
    @SerializedName("OP_NAME")
    private String name;
    @SerializedName("OP_AGE")
    private String age;
    @SerializedName("OP_MAJOR")
    private String major;
    @SerializedName("OP_PHONE")
    private String phone;
    @SerializedName("OP_GRADE")
    private String grade;
    @SerializedName("OP_CLEAN")
    private String clean;
    @SerializedName("OP_YASIK")
    private String yasik;
    @SerializedName("OP_CHARACTER")
    private String character;
    @SerializedName("OP_OUTSIDE_ACTIVITY")
    private String activity;
    @SerializedName("OP_FREQ_DRINK")
    private String freqDrink;
    @SerializedName("OP_DRINK")
    private String drink;
    @SerializedName("OP_SMOKE")
    private String smoke;

    public String getStud_id() {
        return stud_id;
    }

    public void setStud_id(String stud_id) {
        this.stud_id = stud_id;
    }

    public String getOp_stud_id() {
        return op_stud_id;
    }

    public void setOp_stud_id(String op_stud_id) {
        this.op_stud_id = op_stud_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getClean() {
        return clean;
    }

    public void setClean(String clean) {
        this.clean = clean;
    }

    public String getYasik() {
        return yasik;
    }

    public void setYasik(String yasik) {
        this.yasik = yasik;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getFreqDrink() {
        return freqDrink;
    }

    public void setFreqDrink(String freqDrink) {
        this.freqDrink = freqDrink;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getSmoke() {
        return smoke;
    }

    public void setSmoke(String smoke) {
        this.smoke = smoke;
    }

}
