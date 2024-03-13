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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.thuler.vagalivre.R
import br.com.thuler.vagalivre.ui.theme.Roboto

@Composable
fun ParkInfo(icon: Int, info: String, textColor: Int = R.color.text_park_info) {

    Row(verticalAlignment = Alignment.CenterVertically) {

        Icon(
            modifier = Modifier.size(32.dp),
            painter = painterResource(id = icon),
            contentDescription = "Ícone de informação",
            tint = colorResource(id = R.color.text_park_info_blue)
        )
        
        Spacer(modifier = Modifier.width(4.dp))

        AppText(
            modifier = Modifier.padding(start = 4.dp),
            text = info,
            size = 14.sp,
            color = textColor,
            weight = FontWeight.Normal
        )
        
    }

}