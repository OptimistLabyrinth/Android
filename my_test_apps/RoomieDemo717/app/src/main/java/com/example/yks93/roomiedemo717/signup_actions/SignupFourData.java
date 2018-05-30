package com.example.yks93.roomiedemo717.signup_actions;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SignupFourData {

    @SerializedName("age")
    private String age;
    @SerializedName("grade")
    private String grade;
    @SerializedName("personality")
    private List<String> personality;
    @SerializedName("cleanness")
    private String cleanness;
    @SerializedName("nightfood")
    private String nightfood;
    @SerializedName("outsideActivity")
    private String outsideActivity;
    @SerializedName("maxAlcohol")
    private String maxAlcohol;
    @SerializedName("alcoholFreq")
    private String alcoholFrequency;
    @SerializedName("smoking")
    private String smoking;
    @SerializedName("friendComing")
    private String friendComing;

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

    public List<String> getPersonality() {
        return personality;
    }

    public void setPersonality(List<String> personality) {
        this.personality = personality;
    }

    public String getCleanness() {
        return cleanness;
    }

    public void setCleanness(String cleanness) {
        this.cleanness = cleanness;
    }

    public String getNightfood() {
        return nightfood;
    }

    public void setNightfood(String nightfood) {
        this.nightfood = nightfood;
    }

    public String getOutsideActivity() {
        return outsideActivity;
    }

    public void setOutsideActivity(String outsideActivity) {
        this.outsideActivity = outsideActivity;
    }

    public String getMaxAlcohol() {
        return maxAlcohol;
    }

    public void setMaxAlcohol(String maxAlcohol) {
        this.maxAlcohol = maxAlcohol;
    }

    public String getAlcoholFrequency() {
        return alcoholFrequency;
    }

    public void setAlcoholFrequency(String alcoholFrequency) {
        this.alcoholFrequency = alcoholFrequency;
    }

    public String getSmoking() {
        return smoking;
    }

    public void setSmoking(String smoking) {
        this.smoking = smoking;
    }

    public String getFriendComing() {
        return friendComing;
    }

    public void setFriendComing(String friendComing) {
        this.friendComing = friendComing;
    }

}
