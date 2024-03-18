package br.com.thuler.vagalivre.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.PointOfInterest

class SharedViewModel : ViewModel() {
    private val _selectedPOI = MutableLiveData<PointOfInterest?>()
    val selectedPOI: LiveData<PointOfInterest?> = _selectedPOI

    fun selectPOI(poi: PointOfInterest) {
        _selectedPOI.value = poi
    }
}

