package com.thengoding.asistenhujan.models.hourly

import com.google.gson.annotations.SerializedName

data class HourlyResponse(
    @SerializedName("city_name")
    val cityName: String?,
    @SerializedName("country_code")
    val countryCode: String?,
    @SerializedName("data")
    val `data`: List<HourlyData>,
    @SerializedName("lat")
    val lat: String?,
    @SerializedName("lon")
    val lon: String?,
    @SerializedName("state_code")
    val stateCode: String?,
    @SerializedName("timezone")
    val timezone: String?
)