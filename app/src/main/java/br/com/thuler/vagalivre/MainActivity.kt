package br.com.thuler.vagalivre

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.thuler.vagalivre.components.AppLogo
import br.com.thuler.vagalivre.components.CircleButton
import br.com.thuler.vagalivre.components.FormInput
import br.com.thuler.vagalivre.components.RectangularButton
import br.com.thuler.vagalivre.ui.theme.VagaLivreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VagaLivreTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        
        AppLogo(size = 32.sp)
        
        FormInput(
            value = "",
            onValueChange = {},
            label = "Email",
            icon = R.drawable.outline_email_24,
            keyboardType = KeyboardType.Email
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        RectangularButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Acessar",
            onClick = {},
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal
        )

        Spacer(modifier = Modifier.height(16.dp))

        CircleButton(64.dp, Icons.Outlined.Check, Color.White) {}

    }
}