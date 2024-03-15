package br.com.thuler.vagalivre.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import br.com.thuler.vagalivre.ui.theme.Baumans

@Composable
fun AppLogo(size: TextUnit) {
    Text(
        text = "vagalivre",
        fontSize = size,
        color = Color.Black,
        fontFamily = Baumans
    )
}