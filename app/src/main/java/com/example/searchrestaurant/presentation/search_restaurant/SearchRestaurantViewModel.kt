package com.example.searchrestaurant.presentation.search_restaurant

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.searchrestaurant.common.Constents
import com.example.searchrestaurant.common.NetworkResponse
import com.example.searchrestaurant.domain.use_case.SearchRestaurantUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SearchRestaurantViewModel @Inject constructor(
    private val searchRestaurantUseCase: SearchRestaurantUseCase,
): ViewModel() {

    private val _state = mutableStateOf(SearchRestaurantState())
    val state: State<SearchRestaurantState> = _state

    init {
        searchRestaurant(Constents.API_KEY, "1", "34.67", "135.52", "4", "json")
    }

    fun searchRestaurant(
        key: String,
        range: String,
        lat: String,
        lng: String,
        order: String,
        format: String
    ) {
        searchRestaurantUseCase(key, range, lat, lng, order, format).onEach { result ->
            when (result) {
                is NetworkResponse.Success -> {
                    _state.value = SearchRestaurantState(
                        isLoading = false,
                        restaurants = result.data ?: emptyList(),
                    )
                }
                is NetworkResponse.Failure -> {
                    _state.value = SearchRestaurantState(error = result.error)
                }
                is NetworkResponse.Loading -> {
                    _state.value = SearchRestaurantState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}