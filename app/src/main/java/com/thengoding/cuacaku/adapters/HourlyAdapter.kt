/*
 * Cuacaku
 * HourlyAdapter.kt
 * Created by thengoding.com on 2/1/2020
 * Copyright © 2020 The Ngoding. All rights reserved.
 *
 */

package com.thengoding.cuacaku.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thengoding.cuacaku.R
import com.thengoding.cuacaku.models.hourly.HourlyData
import com.thengoding.cuacaku.extentions.setImage

class HourlyAdapter(private val context: Context, private val hourlyData: List<HourlyData>) :
    RecyclerView.Adapter<WeatherHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherHolder {
        return WeatherHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_weather,
                parent,
                false
            ),
            context
        )
    }

    override fun getItemCount(): Int {
        return hourlyData.size
    }

    override fun onBindViewHolder(holder: WeatherHolder, position: Int) {
        holder.bindView(hourlyData[position])
    }
}

class WeatherHolder(itemView: View, val context: Context) : RecyclerView.ViewHolder(itemView) {
    private lateinit var textHour: TextView
    private lateinit var textTemp: TextView
    private lateinit var imgIcon: ImageView
    fun bindView(hourlyData: HourlyData) {
        textHour = itemView.findViewById(R.id.txt_item_hour)
        textTemp = itemView.findViewById(R.id.txt_item_temp)
        imgIcon = itemView.findViewById(R.id.img_item_icon)
        textHour.text = hourlyData.timestampLocal?.split("T")?.get(1) ?: "undefined"
        textTemp.text = context.getString(R.string.temp, hourlyData.appTemp.toString())
        hourlyData.weather?.icon?.let { imgIcon.setImage(it) }
    }
}