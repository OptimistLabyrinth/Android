package com.example.yks93.myrecyclerviewpractice02.pojo;

import android.support.v7.widget.RecyclerView;

public class StringData {

    private String title, genre, year;

    public StringData() {

    }

    public StringData(String title, String genre, String year) {
        this.title = title;
        this.genre = genre;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

}
