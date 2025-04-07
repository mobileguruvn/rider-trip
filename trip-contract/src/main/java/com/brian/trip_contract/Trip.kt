package com.brian.trip_contract

data class Trip(
    val id: String,
    val riderName: String,
    val startTime: Long,
    val destination: String,
    val isOngoing: Boolean,
)
