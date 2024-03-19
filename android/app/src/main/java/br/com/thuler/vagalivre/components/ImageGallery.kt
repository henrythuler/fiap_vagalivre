package br.com.thuler.vagalivre.components

import android.graphics.Bitmap
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ImageGallery(images: List<MutableList<Bitmap>>) {

    LazyRow(modifier = Modifier.fillMaxWidth()) {

        items(images){

//            Image(
//                modifier = Modifier
//                    .size(150.dp)
//                    .padding(end = 16.dp)
//                    .shadow(3.dp),
//                painter = painterResource(id = it),
//                contentDescription = "Imagem do estacionamento",
//                contentScale = ContentScale.Crop
//            )

        }

    }

}