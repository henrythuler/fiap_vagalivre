package br.com.thuler.vagalivre.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import br.com.thuler.vagalivre.R
import br.com.thuler.vagalivre.components.CameraButton
import br.com.thuler.vagalivre.components.CircleButton
import br.com.thuler.vagalivre.components.FormInput
import br.com.thuler.vagalivre.components.Header
import br.com.thuler.vagalivre.components.UserPhoto

@Composable
fun DadosScreen(viewModel: DadosScreenViewModel) {

    Header("Dados Pessoais")


    val nome by viewModel.nome.observeAsState("")

    Box(modifier = Modifier.fillMaxSize()) {

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 15.dp, horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top){

            Spacer(modifier = Modifier.height(70.dp))
            UserPhoto(
                photo = R.drawable.foto,
                size = 100.dp
            )

            CameraButton(icon = R.drawable.ic_launcher_camera_foreground,
                )

            Spacer(modifier = Modifier.height(5.dp))

            Text(text = "joao@email.com",
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(60.dp))

            //Form Column
            Column(modifier = Modifier.fillMaxWidth()) {

                FormInput(
                    value = nome,
                    onValueChange = {viewModel.onNomeChange(it)},
                    label = "Nome",
                    icon = R.drawable.baseline_account_circle_24,
                    keyboardType = KeyboardType.Text
                )

                Spacer(modifier = Modifier.height(200.dp))

            }

            CircleButton(80.dp, Icons.Outlined.Check, Color.White) {}
            }
        }
    }