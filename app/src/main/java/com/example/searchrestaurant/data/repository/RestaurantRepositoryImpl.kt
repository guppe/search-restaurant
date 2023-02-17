package com.example.searchrestaurant.data.repository

import com.example.searchrestaurant.data.remote.HotPepperApi
import com.example.searchrestaurant.data.remote.RestaurantDetailDto
import com.example.searchrestaurant.data.remote.SearchRestaurantResultDto
import com.example.searchrestaurant.domain.repository.RestaurantRepository
import javax.inject.Inject

class RestaurantRepositoryImpl @Inject constructor(
    private val api: HotPepperApi,
): RestaurantRepository {

    override suspend fun searchRestaurant(
        key: String,
        range: String,
        lat: String,
        lng: String,
        order: String,
        format: String,
    ): SearchRestaurantResultDto {
        return api.searchRestaurant(key, range, lat, lng, order, format)
    }

    override suspend fun getRestaurantById(
        key: String,
        id: String,
        format: String
    ): RestaurantDetailDto {
        return api.getRestaurantById(key, id, format)
    }
}