package br.com.vagalivre.app.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.vagalivre.app.R
import br.com.vagalivre.app.ui.theme.Roboto

@Composable
fun FormInput(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    icon: Int,
    trailing: @Composable (() -> Unit)? = null,
    keyboardType: KeyboardType,
    passwordVisible: Boolean? = true
) {
    
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
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
            AppText(
                text = label,
                size = 14.sp,
                color = R.color.black,
                weight = FontWeight.Normal
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "Ícone do formulário",
                tint = Color(0XFF878787)
            )
        },
        trailingIcon = trailing,
        visualTransformation = if (passwordVisible == true) VisualTransformation.None else PasswordVisualTransformation(),
        shape = RoundedCornerShape(12.dp)
    )
    
}

@Preview(showBackground = true)
@Composable
private fun FormInputPreview() {
    FormInput(value = "", onValueChange = {}, label = "Email", icon = R.drawable.outline_email_24, keyboardType = KeyboardType.Email)
}