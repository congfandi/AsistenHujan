/*
 * Asisten Hujan
 * HourlyResponse.kt
 * Created by thengoding.com on 31/12/2019
 * Copyright © 2019 The Ngoding. All rights reserved.
 *
 */

package com.thengoding.cuacaku.models.hourly

import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmObject

data class HourlyResponse(
    @SerializedName("city_name")
    val cityName: String?,
    @SerializedName("country_code")
    val countryCode: String?,
    @SerializedName("data")
    val `data`: RealmList<HourlyData>,
    @SerializedName("lat")
    val lat: String?,
    @SerializedName("lon")
    val lon: String?,
    @SerializedName("state_code")
    val stateCode: String?,
    @SerializedName("timezone")
    val timezone: String?
) : RealmObject()