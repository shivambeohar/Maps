package com.shivambeohar.maps_sat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import com.shivambeohar.maps_sat.databinding.ActivityMapsBinding
import com.shivambeohar.maps_sat.models.MapLocation

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, IRouteResponse {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private lateinit var routeViewModel: RouteViewModel
    private lateinit var listOfCoordinatePoints: ArrayList<LatLng>
    private lateinit var polylineOptions: PolylineOptions

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        routeViewModel = ViewModelProvider(this).get(RouteViewModel::class.java)
        polylineOptions = PolylineOptions()
        listOfCoordinatePoints = ArrayList()
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val listOfPlaces: List<MapLocation> = listOf(
            MapLocation.KOCHIN,
            MapLocation.COIMBATORE,
            MapLocation.MADURAI,
            MapLocation.MUNNAR
        )
        addMarkerToPlaces(listOfPlaces)
        mMap.moveCamera(CameraUpdateFactory.newLatLng(MapLocation.KOCHIN.coordinate))

        routeViewModel.getRoutesFor(MapLocation.KOCHIN.coordinate,MapLocation.COIMBATORE.coordinate)
        routeViewModel.routeResponse = this
    }

    /**
     * Add Marker on the Places provided in the List.
     * @param listOfPlaces Places that needs to be marked.
     */
    private fun addMarkerToPlaces(listOfPlaces: List<MapLocation>) {
        for (location in listOfPlaces) {
            mMap.addMarker(MarkerOptions().position(location.coordinate).title(location.name))
        }
    }

    override fun routeCoordinates(coordinates: List<List<Double>>) {

    }
}