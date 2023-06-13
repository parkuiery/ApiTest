package com.example.apipractice;

import com.google.gson.annotations.SerializedName;

public class WeatherWindModeal {

    @SerializedName("speed")
    double speed = 0.0;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed){
        this.speed = speed;
    }
}
