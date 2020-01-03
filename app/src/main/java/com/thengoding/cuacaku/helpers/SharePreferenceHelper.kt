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
import com.google.gson.Gson
import com.thengoding.cuacaku.models.LocationData

class SharePreferenceHelper(val context: Context) {
    private val pref: SharedPreferences =
        context.getSharedPreferences(DATABASE_NAME, Context.MODE_PRIVATE)
    private val gson = Gson()
    fun saveLocation(location: LocationData) {
        val locationString = gson.toJson(location)
        pref.edit()
            .putString(LOCATION, locationString)
            .apply()
    }

    fun isEmpty(): Boolean {
        return pref.getString(LOCATION, "") == ""
    }

    fun getLocation(): LocationData {
        val locationJson = pref.getString(LOCATION, "")!!
        return gson.fromJson(locationJson, LocationData::class.java)
    }
}