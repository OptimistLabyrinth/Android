package com.example.yks93.roomiedemo717.searchroommate;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/*
 *  Depreciated
 */
public class StudidData {

    @Expose
    @SerializedName("STUD_ID")
    private String stud_id;

    public StudidData (String stud_id) {
        this.stud_id = stud_id;
    }

    public String getStud_id() {
        return stud_id;
    }

    public void setStud_id(String stud_id) {
        this.stud_id = stud_id;
    }

}
