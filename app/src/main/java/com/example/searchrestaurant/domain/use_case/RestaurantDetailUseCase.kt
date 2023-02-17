package com.example.searchrestaurant.domain.use_case

import com.example.searchrestaurant.common.NetworkResponse
import com.example.searchrestaurant.data.remote.toRestaurantDetail
import com.example.searchrestaurant.domain.model.RestaurantDetail
import com.example.searchrestaurant.domain.repository.RestaurantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RestaurantDetailUseCase @Inject constructor(
    private val repository: RestaurantRepository
) {
    operator fun invoke(key: String, id: String, format: String): Flow<NetworkResponse<RestaurantDetail>> = flow {
        emit(NetworkResponse.Loading<RestaurantDetail>())
        val restaurantDetail = repository.getRestaurantById(key, id, format).toRestaurantDetail()
    }
}