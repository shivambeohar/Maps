package com.shivambeohar.maps_sat.models.data

import com.google.gson.annotations.SerializedName

data class Route(
    @SerializedName("info")
    val info: Info,

    @SerializedName("paths")
    val routeCoordinates: List<Path>
)
