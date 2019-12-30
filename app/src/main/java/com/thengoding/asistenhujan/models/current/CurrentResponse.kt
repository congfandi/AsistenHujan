package com.thengoding.asistenhujan.models.current

import androidx.annotation.Nullable
import com.google.gson.annotations.SerializedName

data class CurrentResponse(
    @Nullable
    @SerializedName("count")
    val count: Int,
    @SerializedName("data")
    val `data`: List<CurrentData>
)