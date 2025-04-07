package com.brian.trip_contract

import androidx.navigation.NavGraphBuilder

interface TripNavigator {
    fun tripGraph(onTripSelected: (String) -> Unit) : NavGraphBuilder.() -> Unit
}