package com.example.recipesapp.di

import com.example.recipesapp.data.network.RecipesApi
import com.example.recipesapp.data.repository.RecipesRepositoryImp
import com.example.recipesapp.domain.repository.RecipesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideRecipesRepository(
        recipesApi: RecipesApi
    ): RecipesRepository {
        return RecipesRepositoryImp(recipesApi)
    }
}