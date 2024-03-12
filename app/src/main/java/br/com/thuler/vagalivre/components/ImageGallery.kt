package br.com.thuler.vagalivre.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ImageGallery(images: List<Int>) {

    LazyRow(modifier = Modifier.fillMaxWidth()) {

        items(images){

            Image(
                modifier = Modifier
                    .size(150.dp)
                    .padding(end = 16.dp)
                    .shadow(3.dp),
                painter = painterResource(id = it),
                contentDescription = "Imagem do estacionamento",
                contentScale = ContentScale.Crop
            )

        }

    }

}