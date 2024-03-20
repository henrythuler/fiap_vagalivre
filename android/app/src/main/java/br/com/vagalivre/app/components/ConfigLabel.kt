package br.com.vagalivre.app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.vagalivre.app.R

@Composable
fun ConfigLabel(icon: Int, title: String) {

    Row(modifier = Modifier
        .fillMaxWidth()
        .height(60.dp)
        .background(Color(0x4BCECECE))
        .padding(horizontal = 20.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically){

        Icon(modifier = Modifier.size(25.dp),
            painter = painterResource(id = icon),
            contentDescription = "Ícone da configuração")
        
        Spacer(modifier = Modifier.width(12.dp))

        AppText(
            text = title,
            size = 19.sp,
            color = R.color.black,
            weight = FontWeight.Bold
        )
        
    }

}