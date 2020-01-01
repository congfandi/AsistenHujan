/*
 * Asisten Hujan
 * AsistenExtention.kt
 * Created by thengoding.com on 31/12/2019
 * Copyright © 2019 The Ngoding. All rights reserved.
 *
 */

package com.thengoding.cuacaku.extentions

import android.os.Build
import android.widget.ImageView
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import java.time.LocalDate

fun ImageView.setImage(icon: String) {
    Glide.with(context).load("https://www.weatherbit.io/static/img/icons/$icon.png").into(this)
}

@RequiresApi(Build.VERSION_CODES.O)
fun dateToDay(date: String): String {
    val dates = date.split("-")
    val myDate = LocalDate.of(dates[0].toInt(), dates[1].toInt(), dates[2].toInt())
    val days = listOf("Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu")
    return days[myDate.dayOfWeek.value - 1]
}

@RequiresApi(Build.VERSION_CODES.O)
fun dateToName(date: String): String {
    val moths = listOf(
        "Januari",
        "Februari",
        "Maret",
        "April",
        "Mei",
        "Juni",
        "Juli",
        "Agustus",
        "September",
        "Oktober",
        "Novemer",
        "Desember"
    )
    val day = dateToDay(date)
    val dates = date.split("-")
    val myDate = LocalDate.of(dates[0].toInt(), dates[1].toInt(), dates[2].toInt())
    return "$day, ${myDate.dayOfMonth} ${moths[myDate.monthValue - 1]} ${myDate.year}"
}