package com.thengoding.asistenhujan.models.hourly

import com.google.gson.annotations.SerializedName
import com.thengoding.asistenhujan.models.Weather

data class HourlyData(
    @SerializedName("app_temp")
    val appTemp: Double?,
    @SerializedName("clouds")
    val clouds: Int?,
    @SerializedName("datetime")
    val datetime: String?,
    @SerializedName("dewpt")
    val dewpt: Int?,
    @SerializedName("dhi")
    val dhi: Int?,
    @SerializedName("dni")
    val dni: Int?,
    @SerializedName("ghi")
    val ghi: Int?,
    @SerializedName("pod")
    val pod: String?,
    @SerializedName("pop")
    val pop: Int?,
    @SerializedName("precip")
    val precip: Double?,
    @SerializedName("pres")
    val pres: Int?,
    @SerializedName("rh")
    val rh: Int?,
    @SerializedName("slp")
    val slp: Double?,
    @SerializedName("snow")
    val snow: Double?,
    @SerializedName("snow6h")
    val snow6h: Double?,
    @SerializedName("snow_depth")
    val snowDepth: Int?,
    @SerializedName("solar_rad")
    val solarRad: Int?,
    @SerializedName("temp")
    val temp: Double?,
    @SerializedName("timestamp_local")
    val timestampLocal: String?,
    @SerializedName("timestamp_utc")
    val timestampUtc: String?,
    @SerializedName("ts")
    val ts: String?,
    @SerializedName("uv")
    val uv: Double?,
    @SerializedName("vis")
    val vis: Int?,
    @SerializedName("weather")
    val weather: Weather?,
    @SerializedName("wind_cdir")
    val windCdir: String?,
    @SerializedName("wind_cdir_full")
    val windCdirFull: String?,
    @SerializedName("wind_dir")
    val windDir: Int?,
    @SerializedName("wind_spd")
    val windSpd: Double?
)