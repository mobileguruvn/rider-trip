package com.brian.trip_impl.navigation

const val NAV_ARG_TRIP_ID = "trip_id"

sealed class TripRoutes(val route: String) {
    object TripList : TripRoutes("trips")
    object TripDetail : TripRoutes("trips/{$NAV_ARG_TRIP_ID}") {
        fun createRoute(tripId: String) = "trips/${tripId}"
    }
}