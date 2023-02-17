package com.example.searchrestaurant.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface HotPepperApi {
    @GET("gourmet/v1/")
    suspend fun searchRestaurant(
        @Query("key") key: String,          // APIキー
        @Query("range") range: String,      // 検索範囲
        @Query("lat") lat: String,          // 緯度
        @Query("lng") lng: String,          // 経度
        @Query("format") format: String,    // JSON形式
        @Query("order") order: String       // 順番
    ): SearchRestaurantResultDto
}