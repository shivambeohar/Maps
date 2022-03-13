package com.shivambeohar.maps_sat.models

import com.google.android.gms.maps.model.LatLng

/**
 * Enum for locations holding coordinates.
 */
enum class MapLocation(val coordinate: LatLng) {

    KOCHIN(LatLng(9.931233, 76.267303)),

    COIMBATORE(LatLng(11.004556, 76.961632)),

    MADURAI(LatLng(9.939093, 78.121719)),

    MUNNAR(LatLng(10.089167, 77.059723));
}