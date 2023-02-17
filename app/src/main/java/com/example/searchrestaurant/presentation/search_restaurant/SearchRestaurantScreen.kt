package com.example.searchrestaurant.presentation.search_restaurant

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.foundation.lazy.items
import com.example.searchrestaurant.domain.model.Restaurant

@Composable
fun SearchRestaurantScreen(
    viewModel: SearchRestaurantViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    LazyColumn {
        items(state.restaurants) { restaurant ->
            Text(text = restaurant.access.toString())
        }
    }
}