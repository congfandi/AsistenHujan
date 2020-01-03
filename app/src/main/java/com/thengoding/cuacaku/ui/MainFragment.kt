/*
 * Cuacaku
 * MainFragment.kt
 * Created by thengoding.com on 2/1/2020
 * Copyright © 2020 The Ngoding. All rights reserved.
 *
 */

package com.thengoding.cuacaku.ui

import android.os.Build
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.thengoding.cuacaku.R
import com.thengoding.cuacaku.adapters.DailyAdapter
import com.thengoding.cuacaku.adapters.HourlyAdapter
import com.thengoding.cuacaku.extentions.setImage
import com.thengoding.cuacaku.utils.dateToName
import com.thengoding.cuacaku.viewmodels.MainViewModel

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var liveData: MainViewModel
    private lateinit var rcListWeather: RecyclerView
    private lateinit var rcListWeatherDaily: RecyclerView
    private lateinit var txtLocation: TextView
    private lateinit var txtWeatherTemp: TextView
    private lateinit var txtDay: TextView
    private lateinit var txtWeatherInfo: TextView
    private lateinit var imgWeatherStatus: ImageView
    private lateinit var imgPlace: ImageView

    private fun bindView(view: View): View {
        rcListWeather = view.findViewById(R.id.rc_list_weather)
        rcListWeatherDaily = view.findViewById(R.id.rc_list_weather_daily)
        txtLocation = view.findViewById(R.id.txt_location)
        txtWeatherTemp = view.findViewById(R.id.txt_weather_temp)
        txtDay = view.findViewById(R.id.txt_day)
        txtWeatherInfo = view.findViewById(R.id.txt_weather_info)
        imgWeatherStatus = view.findViewById(R.id.img_weather_status)
        imgPlace = view.findViewById(R.id.img_place)
        return view
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return bindView(inflater.inflate(R.layout.main_fragment, container, false))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        liveData = ViewModelProviders.of(this).get(MainViewModel::class.java)
        rcListWeather.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        context?.let { liveData.loadCurrent(it) }
        liveData.getCurrent().observe(this, Observer { currentData ->
            txtLocation.text = "${currentData.cityName}, ${currentData.countryCode}"
            txtWeatherTemp.text = "${currentData.temp}\u2103"
            txtDay.text = dateToName()
            txtWeatherInfo.text = currentData.weather?.description ?: ""
            currentData.weather?.icon?.let { imgWeatherStatus.setImage(it) }
        })
        context?.let { liveData.loadHourly(it) }
        liveData.getHourly().observe(this, Observer {
            rcListWeather.adapter =
                context?.let { context -> HourlyAdapter(context, it) }
        })

        imgPlace.setOnClickListener {
            Toast.makeText(context, "Hai", Toast.LENGTH_LONG).show()
        }

        rcListWeatherDaily.layoutManager = LinearLayoutManager(context)
        context?.let { liveData.loadDaily(it) }
        liveData.getDaily().observe(this, Observer {
            rcListWeatherDaily.adapter =
                context?.let { context -> DailyAdapter(context, it) }
        })
    }

}
