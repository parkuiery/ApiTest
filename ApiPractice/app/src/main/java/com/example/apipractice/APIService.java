package com.example.apipractice;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {

    @GET("data/2.5/{path}")
    Call<WeatherInfoModeal> doGetJsonData(
            @Path("path") String path,
            @Query("q") String q,
            @Query("appid") String appid
    );

    @GET("data/2.5/weather")
    Call<WeatherInfoModeal> fetchWeatherInfo(
            @Query("lat") Double lat,
            @Query("lon") Double lon,
            @Query("appid") String appid
    );
}
