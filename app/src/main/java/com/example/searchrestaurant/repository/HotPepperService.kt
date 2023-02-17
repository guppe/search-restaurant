package com.example.searchrestaurant.repository

import com.example.searchrestaurant.model.Restaurant
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HotPepperService {
    companion object {
        const val API_KEY = "bb29663fb656ba61"
        const val BASE_URL = "http://webservice.recruit.co.jp/hotpepper/"
    }

    @GET("gourmet/v1/?key=${API_KEY}")
    suspend fun searchRestaurant(
        @Query("range") range: String,      // 検索範囲
        @Query("lat") lat: String,          // 緯度
        @Query("lng") lng: String,          // 経度
        @Query("format") format: String,    // JSON形式
        @Query("order") order: String       // 順番
    ): Response<List<Restaurant>>
}