package br.com.thuler.vagalivre.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.thuler.vagalivre.R

@Composable
fun Header(title: String, onClick: () -> Unit) {

    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp, vertical = 15.dp)
    ){

        Row(
            modifier = Modifier
                .height(30.dp)
                .clickable { onClick() },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            Icon(modifier = Modifier.height(15.dp),
                painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                contentDescription = "Ícone de voltar página",
                tint = colorResource(id = R.color.blue_button)
            )
            AppText(
                text = "Voltar",
                size = 16.sp,
                color = R.color.blue_button,
                weight = FontWeight.Normal
            )
        }

        Row(modifier = Modifier.height(30.dp), verticalAlignment = Alignment.CenterVertically) {
            Title(size = 16.sp, title = title, textAlign = TextAlign.Center)
        }


    }
}

@Preview(showBackground = true)
@Composable
private fun HeaderPreview() {
    Header(title = "Configurações") {
        
    }

}