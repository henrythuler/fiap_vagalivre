package br.com.vagalivre.app.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import br.com.vagalivre.app.ui.theme.Roboto

@Composable
fun Title(size: TextUnit, title: String, textAlign: TextAlign) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = title,
        textAlign = textAlign,
        color = Color.Black,
        fontSize = size,
        fontWeight = FontWeight.Bold,
        fontFamily = Roboto
    )
}