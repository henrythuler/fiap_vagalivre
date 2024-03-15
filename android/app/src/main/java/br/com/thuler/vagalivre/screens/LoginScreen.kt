package br.com.thuler.vagalivre.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.thuler.vagalivre.R
import br.com.thuler.vagalivre.components.AppLogo
import br.com.thuler.vagalivre.components.AppText
import br.com.thuler.vagalivre.components.FormInput
import br.com.thuler.vagalivre.components.RectangularButton
import br.com.thuler.vagalivre.models.LoginViewModel

@Composable
fun LoginScreen(viewModel: LoginViewModel, navController: NavController) {

    // ENDPOINT: https://vagalivre-app.azurewebsites.net/v1/users/login
    // DOCUMENTAÇÃO: https://vagalivre-app.azurewebsites.net/swagger/index.html

    val email by viewModel.email.observeAsState("")
    val password by viewModel.password.observeAsState("")

    Box(modifier = Modifier.fillMaxSize()) {

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp, horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround){

            AppLogo(size = 48.sp)

            //Form Column
            Column(modifier = Modifier.fillMaxWidth()) {

                FormInput(
                    value = email,
                    onValueChange = {viewModel.onEmailChange(it)},
                    label = "Email",
                    icon = R.drawable.outline_email_24,
                    keyboardType = KeyboardType.Email
                )

                Spacer(modifier = Modifier.height(32.dp))

                FormInput(
                    value = password,
                    onValueChange = {viewModel.onPasswordChange(it)},
                    label = "Senha",
                    icon = R.drawable.outline_lock_24,
                    keyboardType = KeyboardType.Password
                )
                
                Spacer(modifier = Modifier.height(32.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Checkbox(
                            checked = true,
                            onCheckedChange = {},
                            colors = CheckboxDefaults.colors(
                                checkedColor = colorResource(id = R.color.input_gray),
                                checkmarkColor = Color.White
                            )
                        )

                        AppText(
                            text = "Lembrar senha",
                            size = 16.sp,
                            color = R.color.text_gray,
                            weight = FontWeight.Normal
                        )

                    }

                    AppText(
                        modifier = Modifier.padding(end = 16.dp),
                        text = "Esqueci a senha",
                        size = 16.sp,
                        color = R.color.text_blue,
                        weight = FontWeight.Normal
                    )

                }
                
                Spacer(modifier = Modifier.height(32.dp))
                
                RectangularButton(
                    modifier = Modifier.fillMaxWidth().height(45.dp),
                    text = "Acessar",
                    onClick = { navController.navigate("home") },
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    border = BorderStroke(1.dp, Color.Black)
                )

            }

            //Footer Column
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                AppText(
                    text = "ou acesse com",
                    size = 16.sp,
                    color = R.color.text_gray,
                    weight = FontWeight.Normal
                )

                Spacer(modifier = Modifier.height(16.dp))

                //Social Media Row
                Row {

                    Image(
                        modifier = Modifier.size(36.dp),
                        painter = painterResource(id = R.drawable.facebook),
                        contentDescription = "Ícone do Facebook",
                    )
                    
                    Spacer(modifier = Modifier.width(12.dp))

                    Image(
                        modifier = Modifier.size(36.dp),
                        painter = painterResource(id = R.drawable.instagram),
                        contentDescription = "Ícone do Instagram"
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    Image(
                        modifier = Modifier.size(36.dp),
                        painter = painterResource(id = R.drawable.pinterest),
                        contentDescription = "Ícone do Pinterest"
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    Image(
                        modifier = Modifier.size(36.dp),
                        painter = painterResource(id = R.drawable.linkedin),
                        contentDescription = "Ícone do LinkedIn"
                    )

                }
                
                Spacer(modifier = Modifier.height(32.dp))

                AppText(
                    text = "Acessar sem uma conta",
                    size = 16.sp,
                    color = R.color.text_blue,
                    weight = FontWeight.Normal
                )
                
            }

        }

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun LoginScreenPreview() {
    LoginScreen(viewModel = LoginViewModel(), navController = rememberNavController())
}