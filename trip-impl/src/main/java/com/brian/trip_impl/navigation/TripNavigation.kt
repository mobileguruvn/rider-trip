package com.brian.trip_impl.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.brian.trip_contract.TripNavigator
import com.brian.trip_impl.ui.trip_detail.TripDetailsScreen
import com.brian.trip_impl.ui.trips.TripListScreen
import javax.inject.Inject

class TripNavigation @Inject constructor() : TripNavigator {
    override fun tripGraph(onTripSelected: (String) -> Unit): NavGraphBuilder.() -> Unit = {
        composable(TripRoutes.TripList.route) {
            TripListScreen(onTripSelected = onTripSelected)
        }

        composable(TripRoutes.TripDetail.route) { backStackEntry ->
            val tripId = backStackEntry.arguments?.getString(NAV_ARG_TRIP_ID)
            TripDetailsScreen(tripId = tripId)
        }
    }
}