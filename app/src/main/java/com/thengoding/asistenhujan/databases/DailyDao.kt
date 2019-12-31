/*
 * Asisten Hujan
 * DailyDao.kt
 * Created by thengoding.com on 31/12/2019
 * Copyright © 2019 The Ngoding. All rights reserved.
 *
 */

package com.thengoding.asistenhujan.databases

import androidx.room.*
import com.thengoding.asistenhujan.helpers.HOURLY
import com.thengoding.asistenhujan.models.daily.DailyData

@Dao
interface DailyDao {

    @Insert
    fun insert(vararg dailyData: DailyData)

    @Update
    fun update(vararg dailyData: DailyData)

    @Delete
    fun delete(dailyData: DailyData)

    @Query("SELECT * FROM $HOURLY")
    fun getCurrent(): List<DailyData>
}