package br.com.thuler.vagalivre.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import br.com.thuler.vagalivre.R
import br.com.thuler.vagalivre.ui.theme.Roboto

@Composable
fun RectangularButton(
    modifier: Modifier,
    text: String,
    onClick: () -> Unit,
    fontSize: TextUnit,
    fontWeight: FontWeight,
    border: BorderStroke?
){

    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.blue_button)),
        shape = RoundedCornerShape(20.dp),
        border = border
    ) {

        Text(
            text = text,
            color = Color.White,
            fontWeight = fontWeight,
            fontSize = fontSize,
            fontFamily = Roboto
        )

    }

}