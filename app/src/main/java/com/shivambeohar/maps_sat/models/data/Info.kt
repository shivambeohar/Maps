package com.shivambeohar.maps_sat.models.data

import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("copyrights")
    val copyrights: List<String>,

    @SerializedName("took")
    val took: Int
)