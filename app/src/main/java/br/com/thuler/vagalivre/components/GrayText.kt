package br.com.thuler.vagalivre.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.TextUnit
import br.com.thuler.vagalivre.R
import br.com.thuler.vagalivre.ui.theme.Roboto

@Composable
fun GrayText(modifier: Modifier = Modifier, text: String, size: TextUnit) {

    Text(
        modifier = Modifier,
        text = text,
        fontSize = size,
        fontFamily = Roboto,
        color = colorResource(id = R.color.text_gray)
    )

}