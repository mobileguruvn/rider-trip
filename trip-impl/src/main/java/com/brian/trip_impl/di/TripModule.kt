package com.brian.trip_impl.di

import com.brian.trip_contract.TripNavigator
import com.brian.trip_contract.TripRepository
import com.brian.trip_impl.data.repository.TripRepositoryImpl
import com.brian.trip_impl.navigation.TripNavigation
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class TripModule {

    @Binds
    abstract fun bindTripRepository(impl: TripRepositoryImpl): TripRepository

    @Binds
    abstract fun bindTripNavigator(impl: TripNavigation): TripNavigator
}