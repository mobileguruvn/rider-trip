package com.brian.trip_impl.ui.trips

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.brian.trip_contract.Trip
import com.brian.trip_contract.TripRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TripListScreen(
    onTripSelected: (String) -> Unit,
    viewModel: TripViewModel = hiltViewModel(),
) {

    val trips by viewModel.trips.collectAsState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Trips") }
            )
        },
        content = { padding ->
            TripListContent(
                trips = trips,
                onTripSelected = onTripSelected,
                modifier = Modifier.padding(padding)
            )
        }

    )

}

@Composable
private fun TripListContent(
    trips: List<Trip>,
    onTripSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier.padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(trips.size) { index ->
            TripCardItem(trip = trips[index], onTripSelected = onTripSelected)
        }
    }
}

@Composable
private fun TripCardItem(
    trip: Trip,
    onTripSelected: (String) -> Unit,
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        colors = CardDefaults.cardColors(contentColor = Color.DarkGray),
        modifier = Modifier.clickable { onTripSelected(trip.id) }) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .sizeIn(minHeight = 30.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1f),
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = "Trip ID: ${trip.id}", style = MaterialTheme.typography.labelLarge)
                Text(
                    text = "Rider Name: ${trip.riderName}",
                    style = MaterialTheme.typography.labelLarge
                )
                Text(
                    text = "Destination: ${trip.destination}",
                    style = MaterialTheme.typography.labelLarge
                )
            }

            Text(
                text = "Ongoing: ${trip.isOngoing}",
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TripListScreenPreview() {
    TripListScreen(onTripSelected = {})
}
