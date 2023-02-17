package com.example.searchrestaurant.presentation.search_restaurant

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SearchRestaurantScreen(
    navController: NavController,
    searchRestaurantViewModel: SearchRestaurantViewModel = viewModel()
) {
    LaunchedEffect(Unit) {
        searchRestaurantViewModel.searchRestaurant("1", "34.67", "135.52", "4", "json")
    }

    Scaffold {
        val observeRestaurant = searchRestaurantViewModel.states.observeAsState()
        observeRestaurant.value?.let { states ->
            LazyColumn {

                
            }
        }
        
    }
}