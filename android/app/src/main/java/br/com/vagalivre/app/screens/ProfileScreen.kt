package br.com.vagalivre.app.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.vagalivre.app.R
import br.com.vagalivre.app.components.AppText
import br.com.vagalivre.app.components.CircleButton
import br.com.vagalivre.app.components.FormInput
import br.com.vagalivre.app.components.Header
import br.com.vagalivre.app.components.UserPhoto
import br.com.vagalivre.app.models.ProfileViewModel

@Composable
fun ProfileScreen(viewModel: ProfileViewModel, navController: NavController, username: String, email: String) {

    val name by viewModel.nome.observeAsState(username)

    Column(modifier = Modifier.fillMaxSize()) {

        Header(title = "Dados Pessoais", onClick = {
            navController.navigate("home/$username/$email")
        })

        Column(modifier = Modifier
            .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Column(modifier = Modifier
                .fillMaxHeight(0.6f),
                verticalArrangement = Arrangement.Center
            ) {
                Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

                    Box(modifier = Modifier
                        .size(100.dp)
                        .clickable { }
                    ){
                        UserPhoto(
                            photo = R.drawable.foto,
                            size = 100.dp
                        )
                        Icon(
                            modifier = Modifier
                                .size(40.dp)
                                .align(Alignment.BottomEnd),
                            painter = painterResource(id = R.drawable.ic_launcher_camera_foreground),
                            contentDescription = "Ícone de camera",
                        )
                    }

                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        AppText(
                            text = email,
                            size = 16.sp,
                            color = R.color.black,
                            weight = FontWeight.Normal
                        )
                    }
                }


                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp)
                    .padding(top = 35.dp)) {
                    FormInput(
                        value = name,
                        onValueChange = {viewModel.onNomeChange(it)},
                        label = "Nome",
                        icon = R.drawable.baseline_account_circle_24,
                        keyboardType = KeyboardType.Text
                    )
                }
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1f)
                .padding(end = 30.dp, bottom = 30.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.End
            ) {

                CircleButton(
                size = 80.dp,
                icon = Icons.Outlined.Check,
                color = Color.White,
                onClick = {
                    navController.navigate("home/$name/$email")
                }
            )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ProfileScreenPreview() {
    ProfileScreen(viewModel = ProfileViewModel(), navController =  rememberNavController(), username = "username", email = "teste@email.com")
}
