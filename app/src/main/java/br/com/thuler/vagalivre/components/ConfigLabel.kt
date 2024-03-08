package br.com.thuler.vagalivre.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.thuler.vagalivre.ui.theme.Roboto

@Composable
fun ConfigLabel(icon: Int, title: String) {

    Row(modifier = Modifier
        .fillMaxWidth()
        .background(Color(0XFFF6F6F6))
        .padding(horizontal = 20.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically){

        Icon(painter = painterResource(id = icon), contentDescription = "Ícone da configuração")
        
        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontFamily = Roboto,
            fontSize = 16.sp,
            color = Color.Black
        )
        
    }

}