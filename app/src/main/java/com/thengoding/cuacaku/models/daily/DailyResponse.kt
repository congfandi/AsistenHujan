/*
 * Asisten Hujan
 * DailyResponse.kt
 * Created by thengoding.com on 31/12/2019
 * Copyright © 2019 The Ngoding. All rights reserved.
 *
 */

package com.thengoding.cuacaku.models.daily

import com.google.gson.annotations.SerializedName

data class DailyResponse(
    @SerializedName("city_name")
    val cityName: String?,
    @SerializedName("country_code")
    val countryCode: String?,
    @SerializedName("data")
    val `data`: List<DailyData>,
    @SerializedName("lat")
    val lat: String?,
    @SerializedName("lon")
    val lon: String?,
    @SerializedName("state_code")
    val stateCode: String?,
    @SerializedName("timezone")
    val timezone: String?
)