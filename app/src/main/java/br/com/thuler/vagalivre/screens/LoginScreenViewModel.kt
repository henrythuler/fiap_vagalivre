package br.com.thuler.vagalivre.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginScreenViewModel : ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    fun onEmailChange(newEmail: String){
        _email.value = newEmail
    }

    fun onPasswordChange(newPassword: String){
        _password.value = newPassword
    }

}