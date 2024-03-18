package br.com.thuler.vagalivre.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.thuler.vagalivre.R
import br.com.thuler.vagalivre.components.ConfigLabel
import br.com.thuler.vagalivre.components.Header

@Composable
fun SettingsScreen(navController: NavController, username: String, email: String) {

    Column(modifier = Modifier.fillMaxSize()) {

        Header(title = "Configurações", onClick = {
            navController.navigate("home/$username/$email")
        })

        Spacer(modifier = Modifier.height(40.dp))

        Column(modifier = Modifier
            .height(55.dp)
            .fillMaxWidth()
            .padding(0.dp)
        )
        {
            ConfigLabel(icon = R.drawable.baseline_translate_24,
                title = "Idioma")
        }

        Spacer(modifier = Modifier.height(32.dp))

        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally)
        {

            var idiomaSelecionado by remember {
                mutableIntStateOf(0)
            }

            Row(modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Start)
                .offset(x = 40.dp, y = 0.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically)
            {
                RadioButton(selected = idiomaSelecionado == 0,
                    onClick = { idiomaSelecionado = 0 },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.Blue))
                Text(modifier = Modifier.offset(x = 20.dp, y = 0.dp),
                    text = "Português") }

            Spacer(modifier = Modifier
                .height(1.dp)
                .border(
                    BorderStroke(
                        2.dp,
                        Color(0x68727070)
                    ),
                    shape = RectangleShape
                )
                .width(300.dp)
                .padding(start = 5.dp, end = 5.dp))

            Row(modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Start)
                .offset(x = 40.dp, y = 0.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically)
            {
                RadioButton(selected = idiomaSelecionado == 1,
                    onClick = { idiomaSelecionado = 1 },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.Blue))
                Text(modifier = Modifier.offset(x = 20.dp, y = 0.dp),
                    text = "Inglês") }

            Spacer(modifier = Modifier
                .height(1.dp)
                .border(
                    BorderStroke(
                        2.dp,
                        Color(0x68727070)
                    ),
                    shape = RectangleShape
                )
                .width(300.dp)
                .padding(start = 5.dp, end = 5.dp))

            Row(modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Start)
                .offset(x = 40.dp, y = 0.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically)
            {
                RadioButton(selected = idiomaSelecionado == 2,
                    onClick = { idiomaSelecionado = 2 },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.Blue))
                Text(modifier = Modifier.offset(x = 20.dp, y = 0.dp),
                    text = "Espanhol") }

            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .border(
                        BorderStroke(
                            2.dp,
                            Color(0x68727070)
                        ),
                        shape = RectangleShape
                    )
                    .width(300.dp)
                    .padding(start = 5.dp, end = 5.dp))
        }

        Spacer(modifier = Modifier.height(50.dp))

        Column {
            ConfigLabel(icon = R.drawable.tune,
                title = "Tema") }

        Spacer(modifier = Modifier.height(32.dp))

        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally)
        {

            var temaSelecionado by remember {
                mutableIntStateOf(0)
            }

            Row(modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Start)
                .offset(x = 40.dp, y = 0.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically)
            {
                RadioButton(selected = temaSelecionado == 0,
                    onClick = { temaSelecionado = 0 },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.Blue))
                Text(modifier = Modifier.offset(x = 20.dp, y = 0.dp),
                    text = "Padrão do Sistema") }

            Spacer(modifier = Modifier
                .height(1.dp)
                .border(
                    BorderStroke(
                        2.dp,
                        Color(0x68727070)
                    ),
                    shape = RectangleShape
                )
                .width(300.dp)
                .padding(start = 5.dp, end = 5.dp))

            Row(modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Start)
                .offset(x = 40.dp, y = 0.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically)
            {
                RadioButton(selected = temaSelecionado == 1,
                    onClick = { temaSelecionado = 1 },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.Blue))
                Text(modifier = Modifier.offset(x = 20.dp, y = 0.dp),
                    text = "Claro") }

            Spacer(modifier = Modifier
                .height(1.dp)
                .border(
                    BorderStroke(
                        2.dp,
                        Color(0x68727070)
                    ),
                    shape = RectangleShape
                )
                .width(300.dp)
                .padding(start = 5.dp, end = 5.dp))

            Row(modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Start)
                .offset(x = 40.dp, y = 0.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically)
            {
                RadioButton(
                    selected = temaSelecionado == 2,
                    onClick = { temaSelecionado = 2 },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.Blue))
                Text(modifier = Modifier.offset(x = 20.dp, y = 0.dp),
                    text = "Escuro") }

            Spacer(modifier = Modifier
                .height(1.dp)
                .border(
                    BorderStroke(
                        2.dp,
                        Color(0x68727070)
                    ),
                    shape = RectangleShape
                )
                .width(300.dp)
                .padding(start = 5.dp, end = 5.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SettingsScreenPreview() {
    SettingsScreen(rememberNavController(), "username", "teste@email.com")
}