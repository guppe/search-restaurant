package com.example.searchrestaurant.data.remote


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PcX(
    val l: String?,
    val m: String?,
    val s: String?
)