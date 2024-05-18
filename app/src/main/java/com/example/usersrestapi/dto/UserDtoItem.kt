package com.example.usersrestapi.dto

import com.example.usersrestapi.User

data class UserDtoItem(
    val address: Address,
    val company: Company,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
)

fun UserDtoItem.toUser(): User {
    return User(
        id = id,
        name = name,
        email = email,
        zipcode = address.zipcode
    )
}