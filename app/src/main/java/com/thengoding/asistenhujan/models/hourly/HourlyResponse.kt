package com.thengoding.asistenhujan.models.hourly

data class HourlyResponse(
    val city_name: String,
    val country_code: String,
    val hourlyData: List<HourlyData>,
    val lat: String,
    val lon: String,
    val state_code: String,
    val timezone: String
)