package br.com.thuler.vagalivre.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import br.com.thuler.vagalivre.components.ParkInfo
import br.com.thuler.vagalivre.components.ParkInfoOpen
import br.com.thuler.vagalivre.components.ParkRating
import br.com.thuler.vagalivre.components.Title

@Composable
fun ParkingScreen(navController: NavController, username: String) {

    Column(modifier = Modifier.fillMaxSize()) {
        
        Header(title = "Estacionamento", onClick = {
            navController.navigate("home/$username")
        })

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)) {

            Title(size = 24.sp, title = "Park Info", textAlign = TextAlign.Start)
            
            Spacer(modifier = Modifier.height(8.dp))
            
            ParkRating(4.5, 274)
            
            Spacer(modifier = Modifier.height(16.dp))

            ParkDetails(closeAt = "18:00", price = 5f,  parkingPlaces = 16)
            
            Spacer(modifier = Modifier.height(24.dp))
            
            ImageGallery(images = listOf(R.drawable.park_1, R.drawable.park_2, R.drawable.park_3))

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

            ParkInfo(
                icon = R.drawable.outline_place_24,
                info = "R. Bandeirantes, 7-36 - Centro, Bauru - SP, 17010-260"
            )
            
            Spacer(modifier = Modifier.height(16.dp))

            ParkInfo(
                icon = R.drawable.phone,
                info = "(014) 99679-6700"
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



@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun ParkingScreenPreview() {
    ParkingScreen(rememberNavController(), "username")
}