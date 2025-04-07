package com.brian.trip_impl.data.repository

import com.brian.trip_contract.Trip
import com.brian.trip_contract.TripRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TripRepositoryImpl @Inject constructor() : TripRepository {
    override fun getActiveTrips(): Flow<List<Trip>> = flow {
        emit(
            listOf(
                Trip(
                    id = "1",
                    riderName = "Brian Hoang",
                    startTime = System.currentTimeMillis(),
                    destination = "Singapore",
                    isOngoing = true
                ),
                Trip(
                    id = "2",
                    riderName = "Brian Hoang",
                    startTime = System.currentTimeMillis(),
                    destination = "Singapore",
                    isOngoing = false
                ),
            )
        )
    }

    override suspend fun getTripDetails(tripId: String): Trip {
        return Trip(
            id = tripId,
            riderName = "Brian Hoang",
            startTime = System.currentTimeMillis(),
            destination = "Singapore",
            isOngoing = true
        )
    }
}