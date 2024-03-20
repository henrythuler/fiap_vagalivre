package br.com.vagalivre.app.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun UserPhoto(photo: Int, size: Dp) {
    Card(
        modifier = Modifier.size(size),
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Image(
            painter = painterResource(photo),
            contentDescription = "Foto do usuário",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}