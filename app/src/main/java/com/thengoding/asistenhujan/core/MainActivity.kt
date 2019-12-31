/*
 * Asisten Hujan
 * MainActivity.kt
 * Created by thengoding.com on 31/12/2019
 * Copyright © 2019 The Ngoding. All rights reserved.
 *
 */

package com.thengoding.asistenhujan.core

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.location.LocationServices
import com.thengoding.asistenhujan.adapters.DailyAdapter
import com.thengoding.asistenhujan.R
import com.thengoding.asistenhujan.adapters.HourlyAdapter
import com.thengoding.asistenhujan.extentions.dateToName
import com.thengoding.asistenhujan.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import com.thengoding.asistenhujan.extentions.setImage

class MainActivity : AppCompatActivity() {


    private fun currentLocation() {
        val mFusedLocation = LocationServices.getFusedLocationProviderClient(this)
        mFusedLocation.lastLocation.addOnSuccessListener(
            this
        ) { location ->

        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        currentLocation()
        rc_list_weather.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val liveData = MainViewModel()
        liveData.loadData()
        liveData.getData().observe(this, Observer { currentData ->
            txt_location.text = "${currentData.cityName}, ${currentData.countryCode}"
            txt_weather_temp.text = "${currentData.temp}\u2103"
            txt_day.text = "${dateToName(currentData.lastObTime.split("T")[0])}"
            txt_weather_info.text = currentData.weather.description
            img_weather_status.setImage(currentData.weather.icon)
        })
        liveData.loadHourly()
        liveData.getHourly().observe(this, Observer {
            rc_list_weather.adapter =
                HourlyAdapter(this, it)
        })

        img_place.setOnClickListener {
            Toast.makeText(this, "Hai", Toast.LENGTH_LONG).show()
        }

        rc_list_weather_daily.layoutManager = LinearLayoutManager(this)
        liveData.loadDaily()
        liveData.getDaily().observe(this, Observer {
            rc_list_weather_daily.adapter =
                DailyAdapter(this, it)
        })
    }
}
