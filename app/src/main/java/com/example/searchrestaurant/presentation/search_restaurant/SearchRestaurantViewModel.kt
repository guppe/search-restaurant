package com.example.searchrestaurant.presentation.search_restaurant

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.searchrestaurant.model.Restaurant
import com.example.searchrestaurant.repository.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

@HiltViewModel
class SearchRestaurantViewModel(): ViewModel() {

    private val repository = RestaurantRepository()

    private val _state = MutableLiveData<List<Restaurant>>()
    val states: LiveData<List<Restaurant>> = _state

    fun searchRestaurant(
        range: String,
        lat: String,
        lng: String,
        order: String,
        format: String,
    ){
        viewModelScope.launch {
            val result = repository.searchRestaurant(range, lat, lng, order, format)
            _state.postValue(result ?: listOf())
        }
    }

}