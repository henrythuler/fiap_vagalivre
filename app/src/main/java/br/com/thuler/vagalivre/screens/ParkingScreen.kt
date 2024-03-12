package br.com.thuler.vagalivre.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.thuler.vagalivre.R
import br.com.thuler.vagalivre.components.Header
import br.com.thuler.vagalivre.components.ImageGallery
import br.com.thuler.vagalivre.components.ParkDetails
import br.com.thuler.vagalivre.components.ParkRating
import br.com.thuler.vagalivre.components.Title

@Composable
fun ParkingScreen(navController: NavController) {

    Column(modifier = Modifier.fillMaxSize()) {
        
        Header(title = "Estacionamento", onClick = {
            navController.navigate("home")
        })

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)) {

            Title(size = 24.sp, title = "Park Info", textAlign = TextAlign.Start)
            
            Spacer(modifier = Modifier.height(8.dp))
            
            ParkRating(4.5, 274)
            
            Spacer(modifier = Modifier.height(16.dp))

            ParkDetails(closeAt = "18:00", price = 5f,  parkingPlaces = 16)
            
            Spacer(modifier = Modifier.height(24.dp))
            
            ImageGallery(images = listOf(R.drawable.park_1, R.drawable.park_2, R.drawable.park_3))



        }

    }

}



@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun ParkingScreenPreview() {
    ParkingScreen(rememberNavController())
}