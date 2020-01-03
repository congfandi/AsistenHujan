/*
 * Cuacaku
 * SplashViewModel.kt
 * Created by thengoding.com on 2/1/2020
 * Copyright © 2020 The Ngoding. All rights reserved.
 *
 */

package com.thengoding.cuacaku.viewmodels

import android.app.Activity
import android.content.Intent
import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thengoding.cuacaku.core.MainActivity
import com.thengoding.cuacaku.models.LocationData

class SplashViewModel : ViewModel() {

    private val locations = MutableLiveData<LocationData>()

    internal fun addLocation(locationData: LocationData) {
        locations.postValue(locationData)
    }

    internal fun getLocation(): LiveData<LocationData> {
        return locations
    }

    fun loadNewPage(activity: Activity) {
        val handler = Handler()
        handler.postDelayed({
            val intent = Intent(activity, MainActivity::class.java)
            activity.startActivity(intent)
            activity.finish()
        }, 1000)
    }
}
