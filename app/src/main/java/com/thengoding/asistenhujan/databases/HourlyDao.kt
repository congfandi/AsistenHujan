/*
 * Asisten Hujan
 * HourlyDao.kt
 * Created by thengoding.com on 31/12/2019
 * Copyright © 2019 The Ngoding. All rights reserved.
 *
 */

package com.thengoding.asistenhujan.databases

import androidx.room.*
import com.thengoding.asistenhujan.helpers.HOURLY
import com.thengoding.asistenhujan.models.hourly.HourlyData

@Dao
interface HourlyDao {

    @Insert
    fun insert(vararg hourlyData: HourlyData)

    @Update
    fun update(vararg hourlyData: HourlyData)

    @Delete
    fun delete(hourlyData: HourlyData)

    @Query("SELECT * FROM $HOURLY")
    fun getCurrent(): List<HourlyData>
}