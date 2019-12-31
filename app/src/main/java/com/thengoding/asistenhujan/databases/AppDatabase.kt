/*
 * Asisten Hujan
 * AppDatabase.kt
 * Created by thengoding.com on 31/12/2019
 * Copyright © 2019 The Ngoding. All rights reserved.
 *
 */

package com.thengoding.asistenhujan.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import com.thengoding.asistenhujan.models.LocationData
import com.thengoding.asistenhujan.models.current.CurrentData
import com.thengoding.asistenhujan.models.daily.DailyData
import com.thengoding.asistenhujan.models.hourly.HourlyData

@Database(
    entities = [CurrentData::class, DailyData::class, HourlyData::class, LocationData::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract val currentDao: CurrentDao
    abstract val dailyDao: DailyDao
    abstract val hourlyDao: HourlyDao
    abstract val locationDao: LocationDao
}