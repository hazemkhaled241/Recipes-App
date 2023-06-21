package com.example.recipesapp.di

import android.content.Context
import com.example.recipesapp.data.local.RecipesDataBase
import com.example.recipesapp.data.local.dao.RecipeDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {
    @Singleton
    @Provides
    fun provideDao(@ApplicationContext context: Context):RecipeDao{
        return RecipesDataBase.getDataBase(context).recipeDao()
    }
}