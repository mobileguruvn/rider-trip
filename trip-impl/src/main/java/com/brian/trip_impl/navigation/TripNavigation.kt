package com.brian.trip_impl.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.brian.trip_contract.TripNavigator
import com.brian.trip_impl.ui.trips.TripListScreen
import javax.inject.Inject

class TripNavigation @Inject constructor() : TripNavigator {
    override fun tripGraph(onTripSelected: (String) -> Unit): NavGraphBuilder.() -> Unit = {
        composable("trip-list") {
            TripListScreen(onTripSelected = onTripSelected)
        }
    }
}