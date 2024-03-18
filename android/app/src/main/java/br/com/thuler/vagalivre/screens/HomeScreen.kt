package br.com.thuler.vagalivre.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import br.com.thuler.vagalivre.models.SharedViewModel
import br.com.thuler.vagalivre.screens._home.MenuButton
import br.com.thuler.vagalivre.screens._home.SearchBar
import br.com.thuler.vagalivre.screens._home.SidePanel
import br.com.thuler.vagalivre.services.CheckPermission
import br.com.thuler.vagalivre.services.getCurrentLocation
import com.google.android.gms.maps.GoogleMapOptions
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings


@Composable
fun HomeScreen(navController: NavController, username: String, email: String, sharedViewModel: SharedViewModel) {

    val context = LocalContext.current
    val brazil = CameraPositionState(CameraPosition.fromLatLngZoom(LatLng(-14.234994, -51.925276), 2f))

    if (!sharedViewModel.positionState.isInitialized)
        sharedViewModel.setCameraPositionState(brazil)

    var defaultCamera by remember { mutableStateOf(sharedViewModel.positionState.value!!)}

    var checkPermissions by remember { mutableStateOf(false) }
    if (checkPermissions) {
        CheckPermission { hasPermission ->
            if (hasPermission)
                getCurrentLocation(context) { location ->
                    sharedViewModel.setCameraPositionState(CameraPositionState(CameraPosition.fromLatLngZoom(location, 17f)))
                    defaultCamera = sharedViewModel.positionState.value!!
                }


            checkPermissions = false
        }
    }

    var dockIsVisible by remember { mutableStateOf(false) }
    var menuIsVisible by remember { mutableStateOf(true) }
    var search by remember { mutableStateOf("") }

    val mapProperties by remember { mutableStateOf(MapProperties()) }
    val isMapLoaded = remember { mutableStateOf(false) }


    Box(modifier = Modifier.fillMaxSize())
    {

        GoogleMap(
            onMapLoaded = { isMapLoaded.value = true},
            uiSettings = MapUiSettings(zoomControlsEnabled = false),
            properties = mapProperties,
            googleMapOptionsFactory = { GoogleMapOptions().mapId("bd305b5cd26de3c2") } ,
            modifier = Modifier.matchParentSize(),
            cameraPositionState = defaultCamera,
            onMapClick = {},
            onPOIClick = {
                sharedViewModel.selectPOI(it)
                navController.navigate("parking/$username/$email")
            }
        ) {
        }

        MenuButton(menuIsVisible = menuIsVisible) { dockIsVisible = true; menuIsVisible = false }

        SearchBar(
            modifier = Modifier.align(Alignment.BottomCenter),
            search = search,
            valueChange = { search = it },
            myLocation = { checkPermissions = true }
        )

        SidePanel(dockIsVisible, navController, username, email) { dockIsVisible = false; menuIsVisible = true }
    }

    if (!isMapLoaded.value) {
        AnimatedVisibility(visible = !isMapLoaded.value) {
            Box(modifier = Modifier.fillMaxSize()){
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}