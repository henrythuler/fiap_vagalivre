package br.com.thuler.vagalivre.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.thuler.vagalivre.components.Header

@Composable
fun ParkingScreen(navController: NavController) {

    Column {
        Header(title = "Estacionamento", onClick = {
            navController.navigate("home")
        })

        Column {

        }
    }
}



@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun ParkingScreenPreview() {
    ParkingScreen(rememberNavController())
}