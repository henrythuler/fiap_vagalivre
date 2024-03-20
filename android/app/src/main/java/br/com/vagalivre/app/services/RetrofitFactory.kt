package br.com.vagalivre.app.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    //BASE_URL
    private val URL = "https://vagalivre-app.azurewebsites.net/v1/users/"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getUserService(): UserLoginService {
        return retrofitFactory.create(UserLoginService::class.java)
    }

}