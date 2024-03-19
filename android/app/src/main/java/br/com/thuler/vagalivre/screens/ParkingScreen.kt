package br.com.thuler.vagalivre.screens

import android.graphics.Bitmap
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
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
import br.com.thuler.vagalivre.services.convertHoursInterval
import br.com.thuler.vagalivre.services.translateWeekdayText
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

    val poi by sharedViewModel.selectedPOI.observeAsState()

    val title = poi?.name ?: "Título Padrão"
    val place = sharedViewModel.place.value

    val openDayTime: MutableList<Pair<String, String>> = mutableListOf()

    //Getting Place Photos

//    Places.initializeWithNewPlacesApiEnabled(context, BuildConfig.MAPS_API_KEY)
//
//    // Specify fields. Requests for photos must always have the PHOTO_METADATAS field.
//    val fields = listOf(Place.Field.PHOTO_METADATAS)
//
//    // Get a Place object (this example uses fetchPlace(), but you can also use findCurrentPlace())
//    val placeRequest = FetchPlaceRequest.newInstance(poi?.placeId!!, fields)
//
//
//    val placesClient: PlacesClient = Places.createClient(context)
//
//    placesClient.fetchPlace(placeRequest)
//        .addOnSuccessListener { response: FetchPlaceResponse ->
//            val place = response.place
//
//            // Get the photo metadata.
//            val metadata = place.photoMetadatas
//            val photoMetadata = metadata
//
//            // Create a FetchPhotoRequest.
//            for(image in photoMetadata!!){
//                val photoRequest = FetchPhotoRequest.builder(image)
//                    .setMaxWidth(150)
//                    .setMaxHeight(150)
//                    .build()
//                placesClient.fetchPhoto(photoRequest)
//                    .addOnSuccessListener { fetchPhotoResponse: FetchPhotoResponse ->
//                        val bitmap = fetchPhotoResponse.bitmap
//                    }.addOnFailureListener { exception: Exception ->
//
//                    }
//            }
//
//        }

    Header(title = "Estacionamento", onClick = {
        navController.navigate("home/$username/$email")
    })

    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.Center) {

            Title(
                size = 24.sp,
                title = title,
                textAlign = TextAlign.Start
            )
            
            Spacer(modifier = Modifier.height(8.dp))

            if(place?.rating != null && place?.userRatingsTotal != null){
                ParkRating(place.rating!!.toFloat(), place.userRatingsTotal!!)
            }

        }

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

            if(place?.address != null){
                ParkInfo(
                    icon = R.drawable.outline_place_24,
                    info = place.address!!
                )
            }
            
            Spacer(modifier = Modifier.height(16.dp))

            if(place?.phoneNumber != null){
                ParkInfo(
                    icon = R.drawable.phone,
                    info = place.phoneNumber!!
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            if(place?.openingHours != null){
                for(d in place.openingHours!!.weekdayText){

                    //Spliting the day and the hour
                    val dayTime = d.split(": ")
                    val day = dayTime[0]
                    val hour = dayTime[1]

                    //Translating the weekday
                    val translatedDay = translateWeekdayText(day)
                    var convertedHour = ""

                    //Verifying if i need to convert the hour or it's closed
                    convertedHour = if(!hour.equals("closed", ignoreCase = true)){
                        convertHoursInterval(hour)
                    }else{
                        "Fechado"
                    }

                    //Adding to the openDayTime list
                    openDayTime.add(Pair(translatedDay, convertedHour))

                }

                ParkInfoOpen(dayTime = openDayTime)

            }

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