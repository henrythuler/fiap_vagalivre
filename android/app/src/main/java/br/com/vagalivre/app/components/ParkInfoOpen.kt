package br.com.vagalivre.app.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.vagalivre.app.R

@Composable
fun ParkInfoOpen(dayTime: List<Pair<String, String>>) {
    Column(
        modifier = Modifier.width(IntrinsicSize.Max),
    ) {

        for(i in dayTime.indices){

            if(i == 0){

                ParkInfo(
                    icon = R.drawable.time,
                    info = "${dayTime[i].first}     ${dayTime[i].second}",
                    textColor = R.color.text_park_info_blue
                )

            }else{

                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 40.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){

                    AppText(
                        modifier = Modifier.weight(1f),
                        text = dayTime[i].first,
                        size = 14.sp,
                        color = R.color.text_park_info,
                        weight = FontWeight.Normal
                    )

                    if(dayTime[i].second.equals("fechado", ignoreCase = true)){
                        Box(Modifier.weight(0.82f)){
                            AppText(
                                text = dayTime[i].second,
                                size = 14.sp,
                                color = R.color.text_park_info,
                                weight = FontWeight.Normal
                            )
                        }
                    }else{
                        AppText(
                            text = dayTime[i].second,
                            size = 14.sp,
                            color = R.color.text_park_info,
                            weight = FontWeight.Normal
                        )
                    }

                }

            }

            Spacer(modifier = Modifier.height(8.dp))

        }

    }
}