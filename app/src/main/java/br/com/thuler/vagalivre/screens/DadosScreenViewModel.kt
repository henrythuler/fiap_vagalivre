package br.com.thuler.vagalivre.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DadosScreenViewModel : ViewModel() {

    private val _nome = MutableLiveData<String>()
    val nome: LiveData<String> = _nome

    fun onNomeChange(newNome: String){
        _nome.value = newNome
    }
}

