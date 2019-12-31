/*
 * Asisten Hujan
 * CurrentDao.kt
 * Created by thengoding.com on 31/12/2019
 * Copyright © 2019 The Ngoding. All rights reserved.
 *
 */

package com.thengoding.asistenhujan.databases

import androidx.room.*
import com.thengoding.asistenhujan.helpers.CURRENT
import com.thengoding.asistenhujan.models.current.CurrentData

@Dao
interface CurrentDao {

    @Insert
    fun insert(vararg currentData: CurrentData)

    @Update
    fun update(vararg currentData: CurrentData)

    @Delete
    fun delete(currentData: CurrentData)

    @Query("SELECT * FROM $CURRENT")
    fun getCurrent(): List<CurrentData>
}