package com.shivambeohar.maps_sat.api

import com.shivambeohar.maps_sat.models.data.Route
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

/**
 * Route API call setup.
 */
interface IRouteApi {

    /**
     * Get the routes from one location to another.
     */
    @GET("route")
    fun getRouteFor(
        @Query("point", encoded = true) point: List<String>,
        @QueryMap(encoded = true) parameters: Map<String, String>
    ): Call<Route>
}