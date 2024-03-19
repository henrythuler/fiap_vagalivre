package br.com.thuler.vagalivre.screens

import android.graphics.Bitmap
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.thuler.vagalivre.BuildConfig
import br.com.thuler.vagalivre.R
import br.com.thuler.vagalivre.components.Header
import br.com.thuler.vagalivre.components.ImageGallery
import br.com.thuler.vagalivre.components.ParkDetails
import br.com.thuler.vagalivre.components.ParkInfo
import br.com.thuler.vagalivre.components.ParkInfoOpen
import br.com.thuler.vagalivre.components.ParkRating
import br.com.thuler.vagalivre.components.Title
import br.com.thuler.vagalivre.models.SharedViewModel
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.api.net.FetchPhotoRequest
import com.google.android.libraries.places.api.net.FetchPhotoResponse
import com.google.android.libraries.places.api.net.FetchPlaceRequest
import com.google.android.libraries.places.api.net.FetchPlaceResponse
import com.google.android.libraries.places.api.net.PlacesClient

@Composable
fun ParkingScreen(
    navController: NavController,
    username: String,
    email: String,
    sharedViewModel: SharedViewModel
) {

    val context = LocalContext.current
    val poi by sharedViewModel.selectedPOI.observeAsState()

    val bitmaps: MutableList<Bitmap> = mutableListOf()

    val title = poi?.name ?: "Título Padrão"
    val place = sharedViewModel.place.value

    Places.initializeWithNewPlacesApiEnabled(context, BuildConfig.MAPS_API_KEY)

    // Specify fields. Requests for photos must always have the PHOTO_METADATAS field.
    val fields = listOf(Place.Field.PHOTO_METADATAS)

    // Get a Place object (this example uses fetchPlace(), but you can also use findCurrentPlace())
    val placeRequest = FetchPlaceRequest.newInstance(poi?.placeId!!, fields)


    val placesClient: PlacesClient = Places.createClient(context)

    placesClient.fetchPlace(placeRequest)
        .addOnSuccessListener { response: FetchPlaceResponse ->
            val place = response.place

            // Get the photo metadata.
            val metadata = place.photoMetadatas
            val photoMetadata = metadata

            // Create a FetchPhotoRequest.
            for(image in photoMetadata!!){
                val photoRequest = FetchPhotoRequest.builder(image)
                    .setMaxWidth(150)
                    .setMaxHeight(150)
                    .build()
                placesClient.fetchPhoto(photoRequest)
                    .addOnSuccessListener { fetchPhotoResponse: FetchPhotoResponse ->
                        val bitmap = fetchPhotoResponse.bitmap
                        image
                    }.addOnFailureListener { exception: Exception ->

                    }
            }

        }

    Column(modifier = Modifier.fillMaxSize()) {
        
        Header(title = "Estacionamento", onClick = {
            navController.navigate("home/$username/$email")
        })

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)) {

            Title(
                size = 24.sp,
                title = title,
                textAlign = TextAlign.Start
            )
            
            Spacer(modifier = Modifier.height(8.dp))

            ParkRating(place?.rating!!.toFloat(), place?.userRatingsTotal!!)
            
            Spacer(modifier = Modifier.height(16.dp))

            ParkDetails(
                closeAt = "18:00",
                price = 5f,
                parkingPlaces = 16
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            ImageGallery(images = listOf(bitmaps))

        }

        Log.i("Hours", place?.openingHours?.weekdayText.toString())

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 32.dp),
            thickness = 1.dp,
            color = Color(0xFFC4C4C4)
        )

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.Start) {

            ParkInfo(
                icon = R.drawable.outline_place_24,
                info = place?.address!!
            )
            
            Spacer(modifier = Modifier.height(16.dp))

            ParkInfo(
                icon = R.drawable.phone,
                info = place?.phoneNumber!!
            )

            Spacer(modifier = Modifier.height(16.dp))

            ParkInfo(
                icon = R.drawable.car,
                info = "24 vagas totais"
            )

            Spacer(modifier = Modifier.height(16.dp))

            ParkInfoOpen(dayTime = listOf(
                Pair("Segunda-feira", "08:00 às 18:00"),
                Pair("Terça-feira", "08:00 às 18:00"),
                Pair("Quarta-feira", "08:00 às 18:00"),
                Pair("Quinta-feira", "08:00 às 18:00"),
                Pair("Sexta-feira", "08:00 às 18:00"),
                Pair("Sábado", "08:00 às 12:00"),
                Pair("Domingo", "Não abre"))
            )

        }

    }

}


//@Preview(showSystemUi = true)
//@Composable
//private fun ParkingScreenPreview() {
//    VagaLivreTheme {
//    ParkingScreen(navController =  rememberNavController(), "username")
//    }
//}