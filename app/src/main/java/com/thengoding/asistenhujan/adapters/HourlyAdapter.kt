/*
 * Asisten Hujan
 * HourlyAdapter.kt
 * Created by thengoding.com on 31/12/2019
 * Copyright © 2019 The Ngoding. All rights reserved.
 *
 */

package com.thengoding.asistenhujan.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thengoding.asistenhujan.R
import com.thengoding.asistenhujan.models.hourly.HourlyData
import com.thengoding.asistenhujan.extentions.setImage

class HourlyAdapter(private val context: Context, private val hourlyData: List<HourlyData>) :
    RecyclerView.Adapter<WeatherHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherHolder {
        return WeatherHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_weather,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return hourlyData.size
    }

    override fun onBindViewHolder(holder: WeatherHolder, position: Int) {
        holder.bindView(hourlyData[position])
    }
}

class WeatherHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private lateinit var textHour: TextView
    private lateinit var textTemp: TextView
    private lateinit var imgIcon: ImageView
    fun bindView(hourlyData: HourlyData) {
        textHour = itemView.findViewById(R.id.txt_item_hour)
        textTemp = itemView.findViewById(R.id.txt_item_temp)
        imgIcon = itemView.findViewById(R.id.img_item_icon)
        textHour.text = hourlyData.timestampLocal?.split("T")?.get(1) ?: "undefined"
        textTemp.text = "${hourlyData.appTemp}\u2103"
        hourlyData.weather?.icon?.let { imgIcon.setImage(it) }
    }
}