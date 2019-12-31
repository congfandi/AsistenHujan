/*
 * Asisten Hujan
 * DatabaseHelper.kt
 * Created by thengoding.com on 31/12/2019
 * Copyright © 2019 The Ngoding. All rights reserved.
 *
 */

package com.thengoding.asistenhujan.helpers

import android.content.Context
import androidx.room.Room
import com.thengoding.asistenhujan.databases.AppDatabase

abstract class DatabaseHelper(context: Context) {
    private var database = Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
        .fallbackToDestructiveMigration()
        .allowMainThreadQueries()
        .build()

    private val currentDb = database.currentDao
    private val hourlyDB = database.hourlyDao
    private val dailyDB = database.dailyDao
    private val locationDB = database.locationDao
}