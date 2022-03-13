package com.shivambeohar.maps_sat.models.data

import com.google.gson.annotations.SerializedName

data class Points(
    @SerializedName("coordinates")
    val coordinates: List<List<Double>>,

    @SerializedName("type")
    val type: String
)
