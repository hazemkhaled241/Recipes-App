package com.example.recipesapp.domain.repository

import com.example.recipesapp.domain.model.Meal

interface FavoriteRecipesRepository  {

     suspend fun getFavoriteRecipes(): List<Meal>
     suspend fun addRecipeToFavorite(meal: Meal)
     suspend fun deleteRecipeToFavorite(meal: Meal)


}