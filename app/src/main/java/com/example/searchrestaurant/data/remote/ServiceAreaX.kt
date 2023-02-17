package com.example.searchrestaurant.data.remote


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ServiceAreaX(
    val code: String?,
    val name: String?
)