package br.com.thuler.vagalivre.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.thuler.vagalivre.R

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ParkDetails(
    isOpen: Boolean = true,
    closeAt: String,
    price: Float,
    parkingPlaces: Int
) {

    FlowRow(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center){

        if(isOpen){

            AppText(
                text = "Aberto",
                size = 16.sp,
                color = R.color.text_park_detail_green,
                weight = FontWeight.Normal
            )

        }else{

            AppText(
                text = "Fechado",
                size = 16.sp,
                color = R.color.text_park_detail_green,
                weight = FontWeight.Normal
            )

        }

        VerticalDivider(
            modifier = Modifier
                .height(16.dp)
                .padding(horizontal = 8.dp)
                .align(Alignment.CenterVertically),
            thickness = 2.dp,
            color = Color.Black
        )

        AppText(
            text = "Fecha às $closeAt",
            size = 16.sp,
            color = R.color.black,
            weight = FontWeight.Normal
        )

        VerticalDivider(
            modifier = Modifier
                .height(16.dp)
                .padding(horizontal = 8.dp)
                .align(Alignment.CenterVertically),
            thickness = 2.dp,
            color = Color.Black
        )

        AppText(
            text = "R$ $price por hora",
            size = 16.sp,
            color = R.color.black,
            weight = FontWeight.Normal
        )

        VerticalDivider(
            modifier = Modifier
                .height(16.dp)
                .padding(horizontal = 8.dp)
                .align(Alignment.CenterVertically),
            thickness = 2.dp,
            color = Color.Black
        )

        AppText(
            text = "$parkingPlaces vagas disponíveis",
            size = 16.sp,
            color = R.color.text_park_detail_green,
            weight = FontWeight.Normal
        )

    }

}