package br.com.thuler.vagalivre.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _loginError = MutableLiveData<Boolean>()
    val loginError: LiveData<Boolean> = _loginError

    private val _passwordVisible = MutableLiveData<Boolean>()
    val passwordVisible = _passwordVisible

    fun onEmailChange(newEmail: String){
        _email.value = newEmail
    }

    fun onPasswordChange(newPassword: String){
        _password.value = newPassword
    }

    fun onLoginErrorChange(newLoginError: Boolean){
        _loginError.value = newLoginError
    }

    fun onPasswordVisibleChange(newPasswordVisible: Boolean){
        _passwordVisible.value = newPasswordVisible
    }

}