package br.com.thuler.vagalivre.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.thuler.vagalivre.ui.theme.Roboto

@Composable
fun ParkInfo(icon: Int, info: String) {

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically) {

        Icon(
            modifier = Modifier.size(32.dp),
            painter = painterResource(id = icon),
            contentDescription = "Ícone de informação",
            tint = Color(0XFF1C48A8)
        )
        
        Spacer(modifier = Modifier.width(4.dp))

        Text(
            text = info,
            color = Color(0xFF857D7D),
            fontSize = 14.sp,
            fontFamily = Roboto
        )
        
    }

}