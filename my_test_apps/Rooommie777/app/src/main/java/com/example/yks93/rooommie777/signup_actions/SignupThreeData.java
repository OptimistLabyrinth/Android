package com.example.yks93.rooommie777.signup_actions;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/*
 *  Depreciated
 */
@Deprecated
public class SignupThreeData {

    @SerializedName("MY_GENDER")
    private String gender;
    @SerializedName("MY_AGE")
    private String age;
    @SerializedName("MY_GRADE")
    private String grade;
    @SerializedName("MY_CHARACTER")
    private List<String> character;
    @SerializedName("MY_CLEAN")
    private String clean;
    @SerializedName("MY_YASIK")
    private String yasik;
    @SerializedName("MY_OUTSIDE_ACTIVITY")
    private String outside_activity;
    @SerializedName("MY_DRINK")
    private String drink;
    @SerializedName("MY_FREQ_DRINK")
    private String freq_drink;
    @SerializedName("MY_SMOKE")
    private String smoke;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public List<String> getCharacter() {
        return character;
    }

    public void setCharacter(List<String> character) {
        this.character = character;
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

    public String getOutside_activity() {
        return outside_activity;
    }

    public void setOutside_activity(String outside_activity) {
        this.outside_activity = outside_activity;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getFreq_drink() {
        return freq_drink;
    }

    public void setFreq_drink(String freq_drink) {
        this.freq_drink = freq_drink;
    }

    public String getSmoke() {
        return smoke;
    }

    public void setSmoke(String smoke) {
        this.smoke = smoke;
    }



}
