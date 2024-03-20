package br.com.vagalivre.app.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.vagalivre.app.R

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
        contentPadding = PaddingValues(0.dp),
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.blue_button)),
        shape = RoundedCornerShape(10.dp),
        border = border,
    ) {

        AppText(
            text = text,
            size = fontSize,
            color = R.color.white,
            weight = fontWeight
        )

    }

}

@Preview
@Composable
private fun RectangularButtonPreview() {
    RectangularButton(
        modifier = Modifier.fillMaxWidth(),
        text = "Acessar",
        onClick = {  },
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        border = BorderStroke(1.dp, Color.Black)
    )
}