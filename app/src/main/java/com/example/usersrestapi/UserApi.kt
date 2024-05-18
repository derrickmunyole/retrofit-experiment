package com.example.usersrestapi

import com.example.usersrestapi.dto.UserDtoItem
import retrofit2.http.GET

interface UsersApi {

    @GET("users")
    suspend fun getUsers(): List<UserDtoItem>

}