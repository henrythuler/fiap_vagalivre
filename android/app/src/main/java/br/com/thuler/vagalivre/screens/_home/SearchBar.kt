package br.com.thuler.vagalivre.screens._home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import br.com.thuler.vagalivre.R
import br.com.thuler.vagalivre.components.FormInput

@Composable
fun SearchBar(modifier: Modifier, search: String, valueChange: (String) -> Unit, myLocation: () -> Unit
) {

    Row(modifier = modifier
        .fillMaxWidth()
        .background(
            Brush.linearGradient(
                colors = listOf(
                    Color(0xFFF5F5F5).copy(alpha = 0.9f),
                    Color.White.copy(alpha = 1f),
                    Color(0xFFF5F5F5).copy(alpha = 0.8f),
                )
            )
        )
    ) {
        FormInput(
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .padding(bottom = 15.dp, top = 7.dp),
            value = search,
            onValueChange = valueChange,
            label = "Procurar",
            icon = R.drawable.search_24px,
            trailing = {
                Icon(
                    painter = painterResource(id = R.drawable.my_location_24px),
                    contentDescription = "Minha localização",
                    tint = Color(0XFF878787),
                    modifier = Modifier.clickable { myLocation() }
                )
            },
            keyboardType = KeyboardType.Ascii
        )
    }
}