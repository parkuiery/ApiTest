package com.example.apipractice;

import com.google.gson.annotations.SerializedName;

import java.nio.file.Watchable;
import java.util.List;


public class WeatherInfoModeal {

    @SerializedName("name")
    String name = "";

    @SerializedName("weather")
    List<WeatherWeatherModeal> weather;

    @SerializedName("main")
    WeatherMainModeal main;

    @SerializedName("wind")
    WeatherWindModeal wind;

    @SerializedName("sys")
    WeatherSysModeal sys;

    @SerializedName("clouds")
    WeatherCloudsModeal clouds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WeatherWeatherModeal> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherWeatherModeal> weather) {
        this.weather = weather;
    }

    public WeatherMainModeal getMain() {
        return main;
    }

    public void setMain(WeatherMainModeal main) {
        this.main = main;
    }

    public WeatherWindModeal getWind() {
        return wind;
    }
    public void setWind(WeatherWindModeal wind){
        this.wind = wind;
    }

    public WeatherSysModeal getSys() {
        return sys;
    }

    public void setSys(WeatherSysModeal sys){
        this.sys = sys;
    }

    public WeatherCloudsModeal getClouds() {
        return clouds;
    }

    public void setClouds(WeatherCloudsModeal clouds){
        this.clouds = clouds;
    }
}
