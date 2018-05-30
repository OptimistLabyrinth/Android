package com.example.yks93.roomiedemo717.signup_actions;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SignupThreeData {

    @SerializedName("gender")
    private String gender;
    @SerializedName("age")
    private String age;
    @SerializedName("grade")
    private String grade;
    @SerializedName("personality")
    private List<String> personality;
    @SerializedName("cleanness")
    private String cleannes;
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

    public List<String> getPersonality() {
        return personality;
    }

    public void setPersonality(List<String> personality) {
        this.personality = personality;
    }

    public String getCleannes() {
        return cleannes;
    }

    public void setCleannes(String cleannes) {
        this.cleannes = cleannes;
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
}
