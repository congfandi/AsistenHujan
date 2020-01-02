/*
 * Cuacaku
 * CurrentResponse.kt
 * Created by thengoding.com on 2/1/2020
 * Copyright © 2020 The Ngoding. All rights reserved.
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