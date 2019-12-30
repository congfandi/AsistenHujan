package com.thengoding.asistenhujan.models.daily

data class DailyResponse(
    val city_name: String,
    val country_code: String,
    val dailyData: List<DailyData>,
    val lat: String,
    val lon: String,
    val state_code: String,
    val timezone: String
)