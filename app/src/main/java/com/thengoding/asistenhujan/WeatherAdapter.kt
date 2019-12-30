package com.thengoding.asistenhujan

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thengoding.asistenhujan.models.hourly.HourlyData
import setImage

class WeatherAdapter(private val context: Context, private val hourlyData: List<HourlyData>) :
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
    lateinit var textHour: TextView
    lateinit var textTemp: TextView
    lateinit var imgIcon: ImageView
    fun bindView(hourlyData: HourlyData) {
        textHour = itemView.findViewById(R.id.txt_item_hour)
        textTemp = itemView.findViewById(R.id.txt_item_temp)
        imgIcon = itemView.findViewById(R.id.img_item_icon)
        textHour.text = hourlyData.timestampLocal?.split("T")?.get(1) ?: "undefined"
        textTemp.text = "${hourlyData.pop}%"
        hourlyData.weather?.icon?.let { imgIcon.setImage(it) }
    }
}