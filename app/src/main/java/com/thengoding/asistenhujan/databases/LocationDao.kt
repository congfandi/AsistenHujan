/*
 * Asisten Hujan
 * LocationDao.kt
 * Created by thengoding.com on 31/12/2019
 * Copyright © 2019 The Ngoding. All rights reserved.
 *
 */

package com.thengoding.asistenhujan.databases

import androidx.room.*
import com.thengoding.asistenhujan.helpers.HOURLY
import com.thengoding.asistenhujan.models.LocationData
import com.thengoding.asistenhujan.models.hourly.HourlyData

@Dao
interface LocationDao {

    @Insert
    fun insert(vararg locationData: LocationData)

    @Update
    fun update(vararg locationData: LocationData)

    @Delete
    fun delete(locationData: LocationData)

    @Query("SELECT * FROM $HOURLY")
    fun getCurrent(): List<LocationData>
}