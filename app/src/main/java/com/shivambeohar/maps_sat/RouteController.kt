package com.shivambeohar.maps_sat

import com.google.android.gms.maps.model.LatLng
import com.shivambeohar.maps_sat.api.RouteRequest
import com.shivambeohar.maps_sat.models.data.Route
import retrofit2.Call
import retrofit2.Response

/**
 * Controller class for making Api calls.
 */
class RouteController {

    /**
     * Holding the list of coordinates from the api response.
     */
    var pathCoordinates: List<List<Double>>? = null

    /**
     * Holds Query parameters.
     */
    private val parameters = HashMap<String, String>()

    /**
     * Holds origin and destination coordinates.
     */
    private val point = ArrayList<String>()

    /**
     * Callback listener for updating UI.
     */
    var routeResponse: IRouteResponse? = null

    /**
     * Common Url query parameters including origin and destination coordinates.
     * @param originLatLng starting location coordinates
     * @param destLatLng destination location coordinates
     */
    private fun addHeaders(originLatLng: LatLng, destLatLng: LatLng) {
        point.clear()
        //parameters are of same name therefore needs to be separated from the QueryMap.
        point.apply {
            add("${originLatLng.latitude},${originLatLng.longitude}")
            add("${destLatLng.latitude},${destLatLng.longitude}")
        }

        parameters.apply {
            put("profile", "car")
            put("locale", "en")
            put("calc_points", "true")
            put("points_encoded", "false")
            put("key", BuildConfig.ROUTE_API_KEY)
        }
    }

    /**
     * Make the API call to get the Route path.
     * @param originLatLng starting location coordinates
     * @param destLatLng destination location coordinates
     */
    fun getRoutesFor(originLatLng: LatLng, destLatLng: LatLng) {
        addHeaders(originLatLng, destLatLng)
        val call = RouteRequest.getRouteRequestApi.getRouteFor(point, parameters)
        call.enqueue(object : retrofit2.Callback<Route> {
            override fun onResponse(call: Call<Route>, response: Response<Route>) {
                if (response.isSuccessful && response.body() != null) {
                    pathCoordinates = response.body()?.routeCoordinates?.get(0)?.points?.coordinates

                    //invoke the callback only when pathCoordinates are not null
                    pathCoordinates?.let { routeResponse?.routeCoordinates(it) }
                }
            }

            override fun onFailure(call: Call<Route>, t: Throwable) {

            }
        })
    }
}