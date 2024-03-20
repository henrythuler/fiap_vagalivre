package br.com.vagalivre.app.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.PointOfInterest
import com.google.android.libraries.places.api.model.Place
import com.google.maps.android.compose.CameraPositionState

class SharedViewModel : ViewModel() {


    private val _selectedPOI = MutableLiveData<PointOfInterest?>()
    val selectedPOI: LiveData<PointOfInterest?> = _selectedPOI
    fun selectPOI(poi: PointOfInterest) {
        _selectedPOI.value = poi
    }

    private val _positionState = MutableLiveData<CameraPositionState?>()
    val positionState: LiveData<CameraPositionState?> = _positionState
    fun setCameraPositionState(position: CameraPositionState) {
        _positionState.value = position
    }

    private val _place = MutableLiveData<Place?>()
    val place: LiveData<Place?> = _place

    fun onPlaceChange(newPlace: Place){
        _place.value = newPlace
    }
}

