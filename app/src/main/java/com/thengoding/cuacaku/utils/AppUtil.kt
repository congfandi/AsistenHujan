/*
 * Cuacaku
 * AppUtil.kt
 * Created by thengoding.com on 2/1/2020
 * Copyright © 2020 The Ngoding. All rights reserved.
 *
 */

package com.thengoding.cuacaku.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate

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