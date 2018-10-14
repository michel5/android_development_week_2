package com.example.michel.geoswip;

public class GeoObject {


    private String mGeoName;

    private int mGeoImageName;


    public GeoObject(int mGeoImageName) {
        this.mGeoImageName = mGeoImageName;

    }

    public int getmGeoImageName() {
        return mGeoImageName;
    }

    public void setmGeoImageName(int mGeoImageName) {
        this.mGeoImageName = mGeoImageName;
    }
}