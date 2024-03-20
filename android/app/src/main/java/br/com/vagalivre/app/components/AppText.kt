package br.com.vagalivre.app.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import br.com.vagalivre.app.ui.theme.Roboto

@Composable
fun AppText(
    modifier: Modifier = Modifier,
    text: String,
    size: TextUnit,
    color: Int,
    weight: FontWeight
) {

    Text(
        modifier = modifier,
        text = text,
        fontSize = size,
        fontFamily = Roboto,
        color = colorResource(id = color),
        fontWeight = weight
    )

}