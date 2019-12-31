/*
 * Asisten Hujan
 * CurrentData.kt
 * Created by thengoding.com on 31/12/2019
 * Copyright © 2019 The Ngoding. All rights reserved.
 *
 */

package com.thengoding.asistenhujan.models.current

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import com.thengoding.asistenhujan.helpers.CURRENT
import com.thengoding.asistenhujan.models.Weather

@Entity(tableName = CURRENT)
data class CurrentData(
    @SerializedName("app_temp")
    val appTemp: Double,
    @SerializedName("aqi")
    val aqi: Int,
    @SerializedName("city_name")
    val cityName: String,
    @SerializedName("clouds")
    val clouds: Int,
    @SerializedName("country_code")
    val countryCode: String,
    @SerializedName("datetime")
    val datetime: String,
    @SerializedName("dewpt")
    val dewpt: Double,
    @SerializedName("dhi")
    val dhi: Double,
    @SerializedName("dni")
    val dni: Double,
    @SerializedName("elev_angle")
    val elevAngle: Double,
    @SerializedName("ghi")
    val ghi: Double,
    @SerializedName("h_angle")
    val hAngle: Double,
    @SerializedName("last_ob_time")
    val lastObTime: String,
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double,
    @SerializedName("ob_time")
    val obTime: String,
    @SerializedName("pod")
    val pod: String,
    @SerializedName("precip")
    val precip: Int,
    @SerializedName("pres")
    val pres: Double,
    @SerializedName("rh")
    val rh: Int,
    @SerializedName("slp")
    val slp: Double,
    @SerializedName("snow")
    val snow: Int,
    @SerializedName("solar_rad")
    val solarRad: Double,
    @SerializedName("state_code")
    val stateCode: String,
    @SerializedName("station")
    val station: String,
    @SerializedName("sunrise")
    val sunrise: String,
    @SerializedName("sunset")
    val sunset: String,
    @SerializedName("temp")
    val temp: Double,
    @SerializedName("timezone")
    val timezone: String,
    @SerializedName("ts")
    val ts: Int,
    @SerializedName("uv")
    val uv: Double,
    @SerializedName("vis")
    val vis: Double,
    @SerializedName("weather")
    val weather: Weather,
    @SerializedName("wind_cdir")
    val windCdir: String,
    @SerializedName("wind_cdir_full")
    val windCdirFull: String,
    @SerializedName("wind_dir")
    val windDir: Int,
    @SerializedName("wind_spd")
    val windSpd: Double
)