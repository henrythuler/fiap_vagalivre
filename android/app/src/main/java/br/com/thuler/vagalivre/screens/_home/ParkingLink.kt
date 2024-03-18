package br.com.thuler.vagalivre.screens._home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ParkingLink(modifier: Modifier, navController: NavController, username: String) {
    Row(modifier = modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.End) {
        Button(modifier = Modifier.size(width = 70.dp, height = 70.dp),
            onClick = {
                navController.navigate("parking/$username")
            }
        ) {
            Text(text = "R$5", fontSize = 12.sp, maxLines = 1)
        }
    }
}