package com.example.recipesapp.di

import com.example.recipesapp.data.local.dao.RecipeDao
import com.example.recipesapp.data.network.RecipesApi
import com.example.recipesapp.data.repository.LoginRepositoryImp
import com.example.recipesapp.data.repository.FavoriteRecipesRepositoryImp
import com.example.recipesapp.data.repository.RecipesRepositoryImp
import com.example.recipesapp.domain.repository.LoginRepository
import com.example.recipesapp.domain.repository.FavoriteRecipesRepository
import com.example.recipesapp.domain.repository.RecipesRepository
import com.example.recipesapp.utils.SharedPrefs
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
    fun provideFavoriteRecipesRepository(
        recipeDao: RecipeDao
    ): FavoriteRecipesRepository {
        return FavoriteRecipesRepositoryImp(recipeDao)
    }
    @Provides
    @Singleton
    fun provideRecipesRepository(
        recipesApi: RecipesApi
    ): RecipesRepository {
        return RecipesRepositoryImp(recipesApi)
    }
    @Provides
    @Singleton
    fun provideLoginRepository(
        sharedPrefs: SharedPrefs,
    ): LoginRepository {
        return LoginRepositoryImp(
            sharedPrefs
        )
    }


}