package br.com.thuler.vagalivre.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.thuler.vagalivre.R
import br.com.thuler.vagalivre.ui.theme.Roboto

@Composable
fun Header(title: String) {

    Box(modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp)){

        Row(
            modifier = Modifier.clickable { /* TO DO VOLTAR*/ },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                contentDescription = "Ícone de voltar página",
                tint = colorResource(id = R.color.blue_button)
            )
            Text(
                text = "Voltar",
                color = colorResource(id = R.color.blue_button),
                fontSize = 14.sp,
                fontFamily = Roboto
            )
        }

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = title,
            textAlign = TextAlign.Center,
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = Roboto
        )

    }

}