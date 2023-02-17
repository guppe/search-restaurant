package com.example.searchrestaurant.presentation

sealed class ScreenRoute(val route: String) {
    object SelectRangeScreen: ScreenRoute("select_range_screen")
    object SearchRestaurantScreen : ScreenRoute("search_restaurant_screen")
    object RestaurantDetailScreen : ScreenRoute("restaurant_detail_screen")
}
