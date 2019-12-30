package com.thengoding.asistenhujan.models.daily

import com.thengoding.asistenhujan.models.Weather

data class DailyData(
    val app_max_temp: Int,
    val app_min_temp: Int,
    val clouds: Int,
    val datetime: String,
    val dewpt: Int,
    val max_dhi: String,
    val max_temp: Double,
    val min_temp: Double,
    val moon_phase: Double,
    val moonrise_ts: Int,
    val moonset_ts: Int,
    val pod: String,
    val pop: Int,
    val precip: Double,
    val pres: Int,
    val rh: Int,
    val slp: Double,
    val snow: Double,
    val snow_depth: Int,
    val sunrise_ts: Int,
    val sunset_ts: Int,
    val temp: Int,
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