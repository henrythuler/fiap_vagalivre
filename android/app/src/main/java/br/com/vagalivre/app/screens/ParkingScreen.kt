package br.com.vagalivre.app.screens

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.vagalivre.app.R
import br.com.vagalivre.app.components.Header
import br.com.vagalivre.app.components.ParkInfo
import br.com.vagalivre.app.components.ParkInfoOpen
import br.com.vagalivre.app.components.ParkRating
import br.com.vagalivre.app.components.Title
import br.com.vagalivre.app.models.SharedViewModel
import br.com.vagalivre.app.services.convertHoursInterval
import br.com.vagalivre.app.services.translateWeekdayText

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

            if(place?.rating != null && place.userRatingsTotal != null){
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

                    //Verifying if i need to convert the hour or it's closed
                    val convertedHour: String = if(!hour.equals("closed", ignoreCase = true)){
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