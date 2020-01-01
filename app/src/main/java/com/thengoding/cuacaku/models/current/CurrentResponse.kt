/*
 * Asisten Hujan
 * CurrentResponse.kt
 * Created by thengoding.com on 31/12/2019
 * Copyright © 2019 The Ngoding. All rights reserved.
 *
 */

package com.thengoding.cuacaku.models.current

import androidx.annotation.Nullable
import com.google.gson.annotations.SerializedName

data class CurrentResponse(
    @Nullable
    @SerializedName("count")
    val count: Int,
    @SerializedName("data")
    val `data`: List<CurrentData>
)