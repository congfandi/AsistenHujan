/*
 * Cuacaku
 * SharePreferenceHelper.kt
 * Created by thengoding.com on 2/1/2020
 * Copyright © 2020 The Ngoding. All rights reserved.
 *
 */

package com.thengoding.cuacaku.helpers

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

class SharePreferenceHelper(val context: Context) {
    private val pref: SharedPreferences =
        context.getSharedPreferences(DATABASE_NAME, Context.MODE_PRIVATE)

    fun saveLocation(lat: String, lon: String) {
        pref.edit()
            .putString("lat", lat)
            .putString("lon", lon)
            .apply()
    }

    fun getLocation(): List<String> {
        val lat = pref.getString("lat", "")!!
        val lon = pref.getString("lon", "")!!
        Log.e("location", "$lat $lon")
        return listOf(lat, lon)
    }
}