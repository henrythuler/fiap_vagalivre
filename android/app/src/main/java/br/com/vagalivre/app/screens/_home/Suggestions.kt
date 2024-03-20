package br.com.vagalivre.app.screens._home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.CameraUpdate
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.libraries.places.api.model.AutocompletePrediction
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.api.net.FetchPlaceRequest
import com.google.android.libraries.places.api.net.PlacesClient
import com.google.maps.android.compose.CameraPositionState

@Composable
fun Sugestions(
    modifier: Modifier,
    places: PlacesClient,
    keyboardController: SoftwareKeyboardController?,
    defaultCamera: CameraPositionState,
    visible: MutableState<Boolean>,
    suggestions: MutableState<List<AutocompletePrediction>>
) {
    AnimatedVisibility(modifier = modifier
        .background(Color.White.copy(alpha = 0.6f))
        .padding(bottom = 85.dp),
        visible = visible.value,
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center))
        {
            LazyColumn(verticalArrangement = Arrangement.Center,modifier = Modifier.align(Alignment.BottomCenter)) {
                items(suggestions.value.size) { index -> // Ajuste aqui para usar o tamanho da lista
                    val suggestion = suggestions.value[index]
                    TextButton(contentPadding = PaddingValues(2.dp),
                        onClick = {
                            resolveAndMoveCamera(suggestion.placeId, places, defaultCamera::move)
                            suggestions.value = emptyList()
                            visible.value = false
                            keyboardController?.hide()
                        }
                    ) {
                        Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)) {
                            Text(suggestion.getPrimaryText(null).toString(), fontWeight = FontWeight.Bold)
                            Text(suggestion.getSecondaryText(null).toString())
                        }
                    }
                }
            }
        }
    }
}

fun resolveAndMoveCamera(placeId: String, placesClient: PlacesClient, moveCamera: (CameraUpdate) -> Unit) {
    val placeRequest = FetchPlaceRequest.builder(placeId, listOf(Place.Field.LAT_LNG)).build()

    placesClient.fetchPlace(placeRequest).addOnSuccessListener { fetchResponse ->
        fetchResponse.place.latLng?.let { latLng ->
            moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 17f))
        }
    }.addOnFailureListener { }
}