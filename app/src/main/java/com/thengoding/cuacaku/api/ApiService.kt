/*
 * Asisten Hujan
 * ApiService.kt
 * Created by thengoding.com on 31/12/2019
 * Copyright © 2019 The Ngoding. All rights reserved.
 *
 */

package com.thengoding.cuacaku.api


import com.thengoding.cuacaku.models.current.CurrentResponse
import com.thengoding.cuacaku.models.daily.DailyResponse
import com.thengoding.cuacaku.models.hourly.HourlyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("current")
    fun current(
        @Query("lat") lat: String, @Query("lon") lon: String,
        @Query("key") key: String, @Query("lang") lang: String
    ): Call<CurrentResponse>

    @GET("forecast/daily")
    fun daily(
        @Query("lat") lat: String, @Query("lon") lon: String,
        @Query("key") key: String, @Query("lang") lang: String
    ): Call<DailyResponse>

    @GET("forecast/hourly")
    fun hourly(
        @Query("lat") lat: String, @Query("lon") lon: String,
        @Query("key") key: String, @Query("lang") lang: String
    ): Call<HourlyResponse>
}