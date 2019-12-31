/*
 * Asisten Hujan
 * DailyAdapter.kt
 * Created by thengoding.com on 31/12/2019
 * Copyright © 2019 The Ngoding. All rights reserved.
 *
 */

package com.thengoding.asistenhujan.adapters

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.thengoding.asistenhujan.R
import com.thengoding.asistenhujan.extentions.dateToDay
import com.thengoding.asistenhujan.models.daily.DailyData
import com.thengoding.asistenhujan.extentions.setImage

class DailyAdapter(private val context: Context, private val dailyData: List<DailyData>) :
    RecyclerView.Adapter<DailyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyHolder {
        return DailyHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_daily,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return dailyData.size
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: DailyHolder, position: Int) {
        holder.bindView(dailyData[position])
    }
}

class DailyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    lateinit var textDate: TextView
    lateinit var textPop: TextView
    lateinit var imgIcon: ImageView
    @RequiresApi(Build.VERSION_CODES.O)
    fun bindView(dailyData: DailyData) {
        textDate = itemView.findViewById(R.id.txt_daily_date)
        textPop = itemView.findViewById(R.id.txt_daily_pop)
        imgIcon = itemView.findViewById(R.id.img_daily_icon)
        textDate.text = dailyData.validDate?.let { dateToDay(it) }
        textPop.text = "${dailyData.temp}\u2103"
        dailyData.weather?.icon?.let { imgIcon.setImage(it) }
    }
}