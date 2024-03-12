package br.com.thuler.vagalivre.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import br.com.thuler.vagalivre.R

@Composable
fun ParkRating(
    rating: Double = 0.0,
    ratingQt: Int = 0
) {

    //If there's a rest in rating divided by one, it means that we have a decimal rating
    val halfStar = rating % 1 != 0.0

    Row(verticalAlignment = Alignment.CenterVertically){
        
        AppText(
            text = rating.toString(),
            size = 12.sp,
            color = R.color.text_gray,
            weight = FontWeight.Normal
        )

        Spacer(modifier = Modifier.width(4.dp))

        for (i in 1..5){
            Icon(
                painter = if(i <= rating.toInt()){
                    painterResource(id = R.drawable.star)
                }else{
                    if(halfStar) painterResource(id = R.drawable.star_half)
                    else painterResource(id = R.drawable.star_outline)
                },
                contentDescription = "Avaliação do estacionamento em estrelas",
                tint = Color(0xFFDFB300)
            )
        }

        Spacer(modifier = Modifier.width(4.dp))

        AppText(
            text = "($ratingQt)",
            size = 12.sp,
            color = R.color.text_gray,
            weight = FontWeight.Normal
        )

    }

}