package com.example.searchrestaurant.data.remote


import com.example.searchrestaurant.domain.model.RestaurantDetail
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RestaurantDetailDto(
    val results: ResultsX?
)

fun RestaurantDetailDto.toRestaurantDetail(): RestaurantDetail {
    return RestaurantDetail(
        //name = results?.shop!!.name
    )
}