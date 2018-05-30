package com.example.yks93.myrecyclerviewpractice01.pojo;

import android.util.Log;

public class SingleHorizontal {

    private int image;
    private String title;
    private String desc;
    private String pubDate;

    private final String TAG = "SingleHorizontal";

    public SingleHorizontal() {

    }

    public SingleHorizontal(int image, String title, String desc, String pubDate) {
        this.image = image;
        this.title = title;
        this.desc = desc;
        this.pubDate = pubDate;
    }

    public int getImage() {
        Log.d(TAG, "getImage: ");
        return image;
    }
    public void setImage(int image) {
        this.image = image;
        Log.d(TAG, "setImage: ");
    }

    public String getTitle() {
        Log.d(TAG, "getTitle: ");
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
        Log.d(TAG, "setTitle: ");
    }

    public String getDesc() {
        Log.d(TAG, "getDesc: ");
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
        Log.d(TAG, "setDesc: ");
    }

    public String getPubDate() {
        Log.d(TAG, "getPubDate: ");
        return pubDate;
    }
    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
        Log.d(TAG, "setPubDate: ");
    }
}
