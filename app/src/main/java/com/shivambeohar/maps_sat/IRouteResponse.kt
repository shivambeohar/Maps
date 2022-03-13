package com.shivambeohar.maps_sat

import com.shivambeohar.maps_sat.models.data.Points

/**
 * Route API response for coordinates.
 */
interface IRouteResponse {

    /**
     * get the Route path coordinates
     * @param points contains list of coordinates for route path.
     */
    fun routeCoordinates(coordinates: List<List<Double>>)

}