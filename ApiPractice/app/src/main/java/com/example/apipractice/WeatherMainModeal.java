package com.example.apipractice;

import com.google.gson.annotations.SerializedName;

public class WeatherMainModeal {

    @SerializedName("temp")
    double temp = 0.0;  //현재 온도

    @SerializedName("humidity")
    double humidity = 0.0; //현재 습도

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }
}
