package com.example.apipractice;

import com.google.gson.annotations.SerializedName;

public class WeatherCloudsModeal {

    @SerializedName("all")
    double all = 0.0; //구름

    public double getAll() {
        return all;
    }

    public void setAll(double all) {
        this.all = all;
    }
}
