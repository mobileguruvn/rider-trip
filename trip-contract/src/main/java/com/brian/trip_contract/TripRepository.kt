package com.brian.trip_contract

import kotlinx.coroutines.flow.Flow

interface TripRepository {
    fun getActiveTrips(): Flow<List<Trip>>
    suspend fun getTripDetails(tripId: String): Trip
}