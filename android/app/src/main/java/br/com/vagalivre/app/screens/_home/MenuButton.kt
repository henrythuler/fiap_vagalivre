package br.com.vagalivre.app.screens._home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.vagalivre.app.components.SmallIcon

@Composable
fun MenuButton(menuIsVisible: Boolean, onClick: () -> Unit ) {
    AnimatedVisibility(visible = menuIsVisible, enter = slideInHorizontally(), exit = slideOutHorizontally()) {
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