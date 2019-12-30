package com.thengoding.asistenhujan.core

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.thengoding.asistenhujan.R
import com.thengoding.asistenhujan.WeatherAdapter
import com.thengoding.asistenhujan.viewmodels.CurrentViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rc_list_weather.adapter = WeatherAdapter(this)
        rc_list_weather.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val liveData = CurrentViewModel()
        liveData.loadData()
        liveData.getData().observe(this, Observer {
//            Log.e("hasil", it.city_name)
        })

    }
}
