package com.example.searchrestaurant.data.remote


import com.example.searchrestaurant.domain.model.Restaurant
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchRestaurantResultDto(
    val results: Results?
)

fun SearchRestaurantResultDto.toRestaurant(): List<Restaurant> {
    return results?.shop!!.map {
        Restaurant(
            name = it?.name,
            //smallImageUrl = it!!.photo?.mobile?.s!!,
            //access = it.access
        )
    }
}