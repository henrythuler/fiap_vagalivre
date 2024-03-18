package br.com.thuler.vagalivre.screens._home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.thuler.vagalivre.components.SmallIcon

@Composable
fun MenuButton(menuIsVisible: Boolean, onClick: () -> Unit ) {
    AnimatedVisibility(visible = menuIsVisible) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
        ) {
            Row(modifier = Modifier.clickable{ onClick() }) {
                SmallIcon(type = "menu")
            }

        }
    }
}