package com.shivambeohar.maps_sat.models.data

import com.google.gson.annotations.SerializedName

data class Instruction(
    @SerializedName("distance")
    val distance: Double,

    @SerializedName("exit_number")
    val exitNumber: Int,

    @SerializedName("exited")
    val exited: Boolean,

    @SerializedName("heading")
    val heading: Double,

    @SerializedName("interval")
    val interval: List<Int>,

    @SerializedName("last_heading")
    val lastHeading: Double,

    @SerializedName("sign")
    val sign: Int,

    @SerializedName("street_name")
    val streetName: String,

    @SerializedName("text")
    val text: String,

    @SerializedName("time")
    val time: Int,

    @SerializedName("turn_angle")
    val turnAngle: Double
)
