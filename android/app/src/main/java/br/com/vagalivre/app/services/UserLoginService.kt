package br.com.vagalivre.app.services

import br.com.vagalivre.app.models.User
import br.com.vagalivre.app.models.UserLogin
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserLoginService {

    @POST("login")
    fun login(@Body userLogin: UserLogin): Call<User>

}