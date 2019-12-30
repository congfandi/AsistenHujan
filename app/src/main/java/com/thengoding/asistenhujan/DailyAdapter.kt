package com.thengoding.asistenhujan

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thengoding.asistenhujan.models.daily.DailyData
import setImage

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

    override fun onBindViewHolder(holder: DailyHolder, position: Int) {
        holder.bindView(dailyData.get(position))
    }
}

class DailyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    lateinit var textDate: TextView
    lateinit var textPop: TextView
    lateinit var imgIcon: ImageView
    fun bindView(dailyData: DailyData) {
        textDate = itemView.findViewById(R.id.txt_daily_date)
        textPop = itemView.findViewById(R.id.txt_daily_pop)
        imgIcon = itemView.findViewById(R.id.img_daily_icon)
        textDate.text = dailyData.validDate
        textPop.text = "${dailyData.pop}%"
        dailyData.weather?.icon?.let { imgIcon.setImage(it) }
    }
}