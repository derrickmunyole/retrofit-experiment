package com.example.usersrestapi.dto

import com.google.gson.annotations.SerializedName

data class Address(
    val city: String,
    val geo: Geo,
    val street: String,
    val suite: String,
    @SerializedName("zipcode")
    val zipcode: String
)