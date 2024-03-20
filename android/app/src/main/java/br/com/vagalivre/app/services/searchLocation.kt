package br.com.vagalivre.app.services

import com.google.android.libraries.places.api.model.AutocompletePrediction
import com.google.android.libraries.places.api.model.AutocompleteSessionToken
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
import com.google.android.libraries.places.api.net.PlacesClient

fun searchLocationByName(searchText: String, placesClient: PlacesClient, updateSuggestions: (List<AutocompletePrediction>) -> Unit) {
    val sessionToken = AutocompleteSessionToken.newInstance()
    val request = FindAutocompletePredictionsRequest.builder()
        .setCountries("BR")
        .setSessionToken(sessionToken)
        .setQuery(searchText)
        .build()

    placesClient.findAutocompletePredictions(request).addOnSuccessListener { response ->
        updateSuggestions(response.autocompletePredictions)
    }.addOnFailureListener { }
}
