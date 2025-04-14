package com.brian.ridertrip.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.brian.trip_contract.TripNavigator
import com.brian.trip_impl.navigation.NAV_ARG_TRIP_ID
import com.brian.trip_impl.navigation.TripRoutes
import com.brian.trip_impl.ui.trip_detail.TripDetailsScreen


@Composable
fun AppNavigation(tripNavigator: TripNavigator) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = TripRoutes.TripList.route) {
        with(tripNavigator.tripGraph { tripId ->
            navController.navigate(TripRoutes.TripDetail.createRoute(tripId))
        }) {
            this()
        }
    }
}