package com.thengoding.asistenhujan.api

import com.google.gson.JsonObject
import com.thengoding.asistenhujan.models.current.CurrentResponse
import com.thengoding.asistenhujan.models.daily.DailyResponse
import com.thengoding.asistenhujan.models.hourly.HourlyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("current")
    fun current(@Query("lat") lat: String, @Query("lon") lon: String, @Query("key") key: String): Call<CurrentResponse>

    @GET("forecast/daily")
    fun daily(@Query("lat") lat: String, @Query("lon") lon: String, @Query("key") key: String): Call<DailyResponse>

    @GET("forecast/hourly")
    fun hourly(@Query("lat") lat: String, @Query("lon") lon: String, @Query("key") key: String): Call<HourlyResponse>
}