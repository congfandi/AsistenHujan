/*
 * Asisten Hujan
 * Weather.kt
 * Created by thengoding.com on 31/12/2019
 * Copyright © 2019 The Ngoding. All rights reserved.
 *
 */

package com.thengoding.cuacaku.models

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject


data class Weather(
    @SerializedName("code")
    val code: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("icon")
    val icon: String
) : RealmObject()