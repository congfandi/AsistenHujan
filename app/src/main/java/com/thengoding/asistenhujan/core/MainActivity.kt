package com.thengoding.asistenhujan.core

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.thengoding.asistenhujan.DailyAdapter
import com.thengoding.asistenhujan.R
import com.thengoding.asistenhujan.WeatherAdapter
import com.thengoding.asistenhujan.viewmodels.CurrentViewModel
import kotlinx.android.synthetic.main.activity_main.*
import setImage

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rc_list_weather.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val liveData = CurrentViewModel()
        liveData.loadData()
        liveData.getData().observe(this, Observer { currentData ->
            txt_location.text = "${currentData.cityName}, ${currentData.countryCode}"
            txt_weather_temp.text = "${currentData.temp}\u2103"
            txt_day.text = currentData.lastObTime
            txt_weather_info.text = currentData.weather.description
            img_weather_status.setImage(currentData.weather.icon)
        })
        liveData.loadHourly()
        liveData.getHourly().observe(this, Observer {
            rc_list_weather.adapter = WeatherAdapter(this, it)
        })

        img_place.setOnClickListener {
            Toast.makeText(this, "Hai", Toast.LENGTH_LONG).show()
        }

        rc_list_weather_daily.layoutManager = LinearLayoutManager(this)
        liveData.loadDaily()
        liveData.getDaily().observe(this, Observer {
            rc_list_weather_daily.adapter = DailyAdapter(this, it)
        })
    }
}
