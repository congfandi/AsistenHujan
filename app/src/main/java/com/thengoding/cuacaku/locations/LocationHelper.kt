/*
 * Cuacaku
 * LocationHelper.kt
 * Created by thengoding.com on 3/1/2020
 * Copyright © 2020 The Ngoding. All rights reserved.
 *
 */

package com.thengoding.cuacaku.locations

import android.content.Context
import android.location.Geocoder
import com.google.android.gms.location.LocationServices
import com.thengoding.cuacaku.models.LocationData
import java.text.SimpleDateFormat
import java.util.*

class LocationHelper(val context: Context) {

    fun getLatLon(result: (LocationData) -> Unit) {
        val mylocation = LocationServices.getFusedLocationProviderClient(context)
        mylocation.lastLocation.addOnSuccessListener {
            getLocationAddress(it.latitude, it.longitude, result)
        }
    }

    private fun getLocationAddress(lat: Double, lon: Double, result: (LocationData) -> Unit) {
        val geoCoder = Geocoder(context)
        val myAddress = geoCoder.getFromLocation(lat, lon, 1)
        if (myAddress.isNotEmpty()) {
            val currentAddress = myAddress[0]
            val simpleFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            val date = simpleFormat.format(Date())
            val locationData = LocationData(
                lat,
                lon,
                currentAddress.countryName,
                currentAddress.adminArea,
                currentAddress.subAdminArea,
                currentAddress.locality,
                currentAddress.subLocality,
                currentAddress.thoroughfare,
                date,
                date
            )
            result(locationData)
        }
    }
}