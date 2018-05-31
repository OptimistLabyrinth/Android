package com.example.yks93.roomiedemo717.searchroommate;

import android.support.v7.widget.RecyclerView;

/*
 *  Depreciated
 */
public class RoommateItem extends RecyclerView.AdapterDataObserver {

    private String stud_id;
    private String id;
    private String pwd;
    private String name;
    private String gender;
    private String phone;
    private String email;
    private String major;

    public RoommateItem(String stud_id, String id, String pwd, String name, String gender, String phone, String email, String major){
        this.stud_id = stud_id;
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.gender = name;
        this.phone = phone;
        this.email = email;
        this.major = major;
    }

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

}
