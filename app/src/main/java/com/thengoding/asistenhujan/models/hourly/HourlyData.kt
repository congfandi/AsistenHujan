package com.thengoding.asistenhujan.models.hourly

import com.thengoding.asistenhujan.models.Weather

data class HourlyData(
    val app_temp: Double,
    val clouds: Int,
    val datetime: String,
    val dewpt: Int,
    val dhi: Int,
    val dni: Int,
    val ghi: Int,
    val pod: String,
    val pop: Int,
    val precip: Double,
    val pres: Int,
    val rh: Int,
    val slp: Double,
    val snow: Double,
    val snow6h: Double,
    val snow_depth: Int,
    val solar_rad: Int,
    val temp: Double,
    val timestamp_local: String,
    val timestamp_utc: String,
    val ts: String,
    val uv: Double,
    val vis: Int,
    val weather: Weather,
    val wind_cdir: String,
    val wind_cdir_full: String,
    val wind_dir: Int,
    val wind_spd: Double
)