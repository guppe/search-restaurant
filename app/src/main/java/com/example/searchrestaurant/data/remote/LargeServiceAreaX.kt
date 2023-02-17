package com.example.searchrestaurant.data.remote


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LargeServiceAreaX(
    val code: String?,
    val name: String?
)