package com.thengoding.asistenhujan.api

import com.thengoding.asistenhujan.models.current.CurrentResponse
import com.thengoding.asistenhujan.models.daily.DailyResponse
import com.thengoding.asistenhujan.models.hourly.HourlyResponse
import retrofit2.http.GET
import retrofit2.http.Path


interface RestApi {

    @GET("current")
    fun current(@Path("lat") lat: String, @Path("lon") lon: String, @Path("key") key: String): CurrentResponse

    @GET("forecast/daily")
    fun daily(@Path("lat") lat: String, @Path("lon") lon: String, @Path("key") key: String): DailyResponse

    @GET("forecast/hourly")
    fun hourly(@Path("lat") lat: String, @Path("lon") lon: String, @Path("key") key: String): HourlyResponse
}