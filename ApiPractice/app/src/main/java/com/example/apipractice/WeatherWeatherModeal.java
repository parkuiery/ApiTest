package com.example.apipractice;

import com.google.gson.annotations.SerializedName;

import java.util.SplittableRandom;

public class WeatherWeatherModeal {

    @SerializedName("main")
    String main = "";  //날씨

    @SerializedName("description")
    String description = ""; // 상세 날씨 설명

    @SerializedName("icon")
    String icon = "";

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
