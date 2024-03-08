package br.com.thuler.vagalivre.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.thuler.vagalivre.R
import br.com.thuler.vagalivre.ui.theme.Roboto

@Composable
fun FormInput(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    icon: Int,
    keyboardType: KeyboardType
) {
    
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(id = R.color.input_gray),
            unfocusedBorderColor = colorResource(id = R.color.input_gray),
            cursorColor = colorResource(id = R.color.input_gray)
        ),
        textStyle = TextStyle(
            fontSize = 16.sp,
            color = Color.Black,
            fontFamily = Roboto
        ),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        label = {
            Text(
                text = label,
                fontSize = 14.sp,
                color = Color.Black,
                fontFamily = Roboto
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "Ícone do formulário",
                tint = Color(0XFF878787)
            )
        },
        shape = RoundedCornerShape(16.dp)
    )
    
}