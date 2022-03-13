package com.shivambeohar.maps_sat.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RouteRequest {
    private const val BASE_URL = "https://graphhopper.com/api/1/"

    private fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val getRouteRequestApi: IRouteApi by lazy {
        retrofit().create(IRouteApi::class.java)
    }
}