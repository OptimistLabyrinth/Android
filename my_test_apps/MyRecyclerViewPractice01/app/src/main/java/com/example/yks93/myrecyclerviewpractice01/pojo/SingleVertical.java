package com.example.yks93.myrecyclerviewpractice01.pojo;

import android.util.Log;

public class SingleVertical {

    private String header;
    private String subHeader;
    private int image;

    private final String TAG = "SingleVertical";

    public SingleVertical() {

    }

    public SingleVertical(String header, String subHeader, int image) {
        this.header = header;
        this.subHeader = subHeader;
        this.image = image;
    }

    public String getHeader() {
        Log.d(TAG, "getHeader: ");
        return header;
    }
    public void setHeader(String header) {
        this.header = header;
        Log.d(TAG, "setHeader: ");
    }

    public String getSubHeader() {
        Log.d(TAG, "getSubHeader: ");
        return subHeader;
    }
    public void setSubHeader(String subHeader) {
        this.subHeader = subHeader;
        Log.d(TAG, "setSubHeader: ");
    }

    public int getImage() {
        Log.d(TAG, "getImage: ");
        return image;
    }
    public void setImage(int image) {
        this.image = image;
        Log.d(TAG, "setImage: ");
    }

}
