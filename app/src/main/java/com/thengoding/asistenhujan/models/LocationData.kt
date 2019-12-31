/*
 * Asisten Hujan
 * LocationData.kt
 * Created by thengoding.com on 31/12/2019
 * Copyright © 2019 The Ngoding. All rights reserved.
 *
 */

package com.thengoding.asistenhujan.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.thengoding.asistenhujan.helpers.LOCATION

@Entity(tableName = LOCATION)
class LocationData(
    @PrimaryKey
    var id: Int,
    var lat: Long,
    var lon: Long,
    var country: String,
    var province: String,
    var city: String,
    var district: String,
    var village: String,
    var address: String,
    var created: String,
    var updated: String
)