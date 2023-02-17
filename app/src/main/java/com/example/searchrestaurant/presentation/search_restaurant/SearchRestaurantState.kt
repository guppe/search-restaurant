package com.example.searchrestaurant.presentation.search_restaurant

import com.example.searchrestaurant.domain.model.Restaurant

data class SearchRestaurantState (
    val isLoading: Boolean = false,
    val restaurants: List<Restaurant> = emptyList(),
    val error: String? = null,
)
