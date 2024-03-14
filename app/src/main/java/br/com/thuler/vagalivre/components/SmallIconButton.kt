package br.com.thuler.vagalivre.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ExitToApp
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SmallIcon(type: String) {

    var modifier = Modifier.size(50.dp, 50.dp).padding(14.dp)

    val icon = when(type){
        "settings" -> Icons.Outlined.Settings
        "close" -> Icons.Outlined.Close
        "logout" -> Icons.AutoMirrored.Outlined.ExitToApp
        "menu" -> {
            modifier = Modifier.size(60.dp, 60.dp).padding(5.dp)
            Icons.Rounded.Menu
        }
        else -> Icons.Default.Warning
    }


    Row(modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = type,
            tint = Color.Black,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SmallIconPreview() {
    SmallIcon(type = "logout")
}