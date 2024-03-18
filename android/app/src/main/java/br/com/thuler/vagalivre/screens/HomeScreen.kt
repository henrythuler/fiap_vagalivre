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
import br.com.thuler.vagalivre.screens._home.MenuButton
import br.com.thuler.vagalivre.screens._home.ParkingLink
import br.com.thuler.vagalivre.screens._home.SearchBar
import br.com.thuler.vagalivre.screens._home.SidePanel
import br.com.thuler.vagalivre.services.CheckPermission
import br.com.thuler.vagalivre.services.getCurrentLocation
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties


@Composable
fun HomeScreen(navController: NavController) {

    val context = LocalContext.current
    var defaultCamera by remember { mutableStateOf(CameraPositionState(CameraPosition.fromLatLngZoom(LatLng(-14.234994, -51.925276), 2f))) }

    var checkPermissions by remember { mutableStateOf(false) }
    if (checkPermissions) {
        CheckPermission {hasPermission ->
            if (hasPermission)
                getCurrentLocation(context) { location -> defaultCamera = CameraPositionState(CameraPosition.fromLatLngZoom(location, 15f)) }
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
            modifier = Modifier.matchParentSize(),
            cameraPositionState = defaultCamera,
            properties = mapProperties,
            onMapClick = { }
        ) { }

        MenuButton(menuIsVisible = menuIsVisible) { dockIsVisible = true; menuIsVisible = false }
        ParkingLink(modifier = Modifier.align(Alignment.Center), navController = navController)

        SearchBar(
            modifier = Modifier.align(Alignment.BottomCenter),
            search = search,
            valueChange = { search = it },
            myLocation = { checkPermissions = true }
        )

        SidePanel(dockIsVisible, navController) { dockIsVisible = false; menuIsVisible = true }
    }

    if (!isMapLoaded.value) {
        AnimatedVisibility(visible = !isMapLoaded.value) {
            Box(modifier = Modifier.fillMaxSize()){
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}