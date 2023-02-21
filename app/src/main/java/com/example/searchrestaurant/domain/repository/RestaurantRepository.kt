package com.example.searchrestaurant.domain.repository

import com.example.searchrestaurant.data.remote.RestaurantDetailDto
import com.example.searchrestaurant.data.remote.SearchRestaurantResultDto

interface RestaurantRepository {

    suspend fun searchRestaurant(
        //key: String,
        range: String,
        lat: String,
        lng: String,
        order: String,
        //format: String,
    ): SearchRestaurantResultDto

    suspend fun getRestaurantById(
        key: String,
        id: String,
        format: String
    ): RestaurantDetailDto
}