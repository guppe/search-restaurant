package com.example.searchrestaurant.presentation.search_restaurant

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import coil.compose.AsyncImage
import com.example.searchrestaurant.domain.model.Restaurant

@Composable
fun SearchRestaurantScreen(
    viewModel: SearchRestaurantViewModel = hiltViewModel()
) {
   val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        when {
            state.isLoading -> {
                // ローディング
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            !state.error.isNullOrBlank() -> {
                // エラー表示
                Text(
                    text = state.error,
                    modifier = Modifier.align(Alignment.Center),
                    color = MaterialTheme.colors.error,
                )
            }
            else -> {
                state.restaurants?.let { restaurants ->
                    LazyColumn {
                        items(state.restaurants) { restaurant ->
                            Text(text = restaurant.access.toString())
                        }
                    }
                }
            }
        }
    }
}