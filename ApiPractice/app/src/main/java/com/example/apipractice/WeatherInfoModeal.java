package com.example.apipractice;

import com.google.gson.annotations.SerializedName;

import java.nio.file.Watchable;
import java.util.List;


public class WeatherInfoModeal {

    @SerializedName("name")
    String name = "";

    @SerializedName("weather")
    List<WeatherInfoModeal> weather;

    @SerializedName("main")
    WeatherInfoModeal main;

    @SerializedName("wind")
    WeatherInfoModeal wind;

    @SerializedName("sys")
    WeatherInfoModeal sys;

    @SerializedName("clouds")
    WeatherInfoModeal clouds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WeatherInfoModeal> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherInfoModeal> weather) {
        this.weather = weather;
    }

    public WeatherInfoModeal getMain() {
        return main;
    }

    public void setMain(WeatherInfoModeal main) {
        this.main = main;
    }

    public WeatherInfoModeal getWind() {
        return wind;
    }
    public void setWind(WeatherInfoModeal wind){
        this.wind = wind;
    }

    public WeatherInfoModeal getSys() {
        return sys;
    }

    public void setSys(WeatherInfoModeal sys){
        this.sys = sys;
    }

    public WeatherInfoModeal getClouds() {
        return clouds;
    }

    public void setClouds(WeatherInfoModeal clouds){
        this.clouds = clouds;
    }
}
