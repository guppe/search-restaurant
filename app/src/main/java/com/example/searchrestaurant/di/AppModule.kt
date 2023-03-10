package com.example.searchrestaurant.di

import com.example.searchrestaurant.common.Constents.BASE_URL
import com.example.searchrestaurant.data.remote.HotPepperApi
import com.example.searchrestaurant.data.repository.RestaurantRepositoryImpl
import com.example.searchrestaurant.domain.repository.RestaurantRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHotPepperApi(): HotPepperApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
                ).asLenient()
            )
            .build()
            .create(HotPepperApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRestaurantRepository(api: HotPepperApi): RestaurantRepository {
        return RestaurantRepositoryImpl(api)
    }
}