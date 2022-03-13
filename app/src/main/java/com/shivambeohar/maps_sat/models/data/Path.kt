package com.shivambeohar.maps_sat.models.data

import com.google.gson.annotations.SerializedName

data class Path(
    @SerializedName("ascend")
    val ascend: Double,

    @SerializedName("bbox")
    val bbox: List<Double>,

    @SerializedName("descend")
    val descend: Double,

    @SerializedName("distance")
    val distance: Double,

    @SerializedName("instructions")
    val instructions: List<Instruction>,

    @SerializedName("legs")
    val legs: List<Any>,

    @SerializedName("points")
    val points: Points,

    @SerializedName("points_encoded")
    val pointsEncoded: Boolean,

    @SerializedName("snapped_waypoints")
    val snappedWaypoints: SnappedWaypoints,

    @SerializedName("time")
    val time: Int,

    @SerializedName("transfers")
    val transfers: Int,

    @SerializedName("weight")
    val weight: Double
)

