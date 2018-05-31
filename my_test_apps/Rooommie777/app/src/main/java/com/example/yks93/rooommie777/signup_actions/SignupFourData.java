package com.example.yks93.rooommie777.signup_actions;

import com.google.gson.annotations.SerializedName;

/*
 *  Depreciated
 */
public class SignupFourData {

    @SerializedName("OP_AGE")
    private String age;
    @SerializedName("OP_GRADE")
    private String grade;
    @SerializedName("OP_CLEAN")
    private String clean;
    @SerializedName("OP_YASIK")
    private String yasik;
    @SerializedName("OP_OUTSIDE_ACTIVITY")
    private String outside_activity;
    @SerializedName("OP_DRINK")
    private String drink;
    @SerializedName("OP_FREQ_DRINK")
    private String freq_drink;
    @SerializedName("OP_SMOKE")
    private String smoke;
    @SerializedName("AGREE_WITH")
    private String agree_with;

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

    public String getAgree_with() {
        return agree_with;
    }

    public void setAgree_with(String agree_with) {
        this.agree_with = agree_with;
    }
}
