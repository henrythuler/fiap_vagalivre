package br.com.thuler.vagalivre.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun CameraButton(icon: Int) {

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 0.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically) {


        Icon(
            modifier = Modifier.size(50.dp),
            painter = painterResource(id = icon),
            contentDescription = "Ícone de camera"
        )
    }
}
