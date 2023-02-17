package com.example.searchrestaurant.domain.use_case

import com.example.searchrestaurant.common.NetworkResponse
import com.example.searchrestaurant.data.remote.toRestaurant
import com.example.searchrestaurant.domain.model.Restaurant
import com.example.searchrestaurant.domain.repository.RestaurantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchRestaurantUseCase @Inject constructor(
    private val repository: RestaurantRepository
){
    operator fun invoke(
        key: String,
        range: String,
        lat: String,
        lng: String,
        order: String,
        format: String,
    ): Flow<NetworkResponse<List<Restaurant>>> = flow {
        try {
            emit(NetworkResponse.Loading<List<Restaurant>>())
            val restaurants = repository.searchRestaurant(key, range, lat, lng, order, format).toRestaurant()
            emit(NetworkResponse.Success<List<Restaurant>>(restaurants))
        } catch (e: Exception) {
            emit(NetworkResponse.Failure<List<Restaurant>>(e.message.toString()))
        }
    }
}