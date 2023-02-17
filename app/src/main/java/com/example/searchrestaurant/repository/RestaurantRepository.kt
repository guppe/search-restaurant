package com.example.searchrestaurant.repository

import com.example.searchrestaurant.model.Restaurant
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RestaurantRepository {
    companion object {
        private val hotPepperService: HotPepperService = Retrofit.Builder()
            .baseUrl(HotPepperService.BASE_URL)
            .client(OkHttpClient())
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
                )
            )
            .build()
            .create(HotPepperService::class.java)
    }

    suspend fun searchRestaurant(
        range: String,
        lat: String,
        lng: String,
        order: String,
        format: String,
    ): List<Restaurant>? =
        hotPepperService.searchRestaurant(range, lat, lng, order, format).body()
}