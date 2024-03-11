package br.com.thuler.vagalivre.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(navController: NavController) {
    Column {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            text = "Home",
            fontSize = 26.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )

        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            onClick = { navController.navigate("profile") }) {
            Text(text = "Dados")
        }

        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            onClick = { navController.navigate("settings") }) {
            Text(text = "Configurações")
        }

        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            onClick = { navController.navigate("parking") }) {
            Text(text = "Estacionamento")
        }

        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            onClick = { navController.navigate("login") }) {
            Text(text = "Sair")
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}