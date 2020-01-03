/*
 * Cuacaku
 * MainActivity.kt
 * Created by thengoding.com on 2/1/2020
 * Copyright © 2020 The Ngoding. All rights reserved.
 *
 */

package com.thengoding.cuacaku.core

import android.location.Address
import android.location.Geocoder
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.thengoding.cuacaku.R
import com.thengoding.cuacaku.helpers.SharePreferenceHelper
import com.thengoding.cuacaku.ui.MainFragment
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private fun changeUI(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, fragment)
            .commitNow()

    }

    private fun getLocationName() {
        val latlon = SharePreferenceHelper(this).getLocation()
        val geocoder = Geocoder(this)
        try {
            val address: List<Address> =
                geocoder.getFromLocation(latlon[0].toDouble(), latlon[1].toDouble(), 1)
            val currentAddress = address[0]
            Log.e("locationku","${currentAddress.countryName}\n${currentAddress.locality}\n${currentAddress.adminArea}")
        }catch (e: IOException){

        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        changeUI(MainFragment.newInstance())
        getLocationName()
    }
}
