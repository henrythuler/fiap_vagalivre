package br.com.thuler.vagalivre.services

import br.com.thuler.vagalivre.models.User
import br.com.thuler.vagalivre.models.UserLogin
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserLoginService {

    @POST("login")
    fun login(@Body userLogin: UserLogin): Call<User>

}