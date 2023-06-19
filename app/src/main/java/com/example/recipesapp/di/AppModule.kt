package com.example.recipesapp.di

import com.example.recipesapp.data.network.RecipesApi
import com.example.recipesapp.data.network.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideNewsApi(): RecipesApi {
        return RetrofitClient.api
    }
}