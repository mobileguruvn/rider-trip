package com.brian.ridertrip.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.brian.trip_contract.TripNavigator
import com.brian.trip_impl.ui.trip_detail.TripDetailsScreen


@Composable
fun AppNavigation(tripNavigator: TripNavigator) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "trip-list") {
        with(tripNavigator.tripGraph { tripId ->
            navController.navigate("trip-details/$tripId")
        }) {
            this()
        }

        composable("trip-details/{tripId}") { backStackEntry ->
            val tripId = backStackEntry.arguments?.getString("tripId")
            TripDetailsScreen(tripId = tripId)
        }

    }
}