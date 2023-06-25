package com.example.recipesapp.di

import com.example.recipesapp.data.network.RecipesApi
import com.example.recipesapp.data.network.RetrofitClient
import com.example.recipesapp.utils.DispatcherProvider
import com.example.recipesapp.utils.StandardDispatcher
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

    @Provides
    @Singleton
    fun provideStandardProvider(): DispatcherProvider {
        return StandardDispatcher()
    }
}