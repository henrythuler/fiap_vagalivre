package br.com.thuler.vagalivre.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind

@Composable
fun ParkOptions(onOverview: () -> Unit) {

    Row(modifier = Modifier.fillMaxWidth()) {

        val selectedModifier = Modifier.clickable{onOverview()}.drawBehind {

        }

    }

}