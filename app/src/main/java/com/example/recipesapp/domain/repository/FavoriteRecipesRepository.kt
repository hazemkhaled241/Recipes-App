package com.example.recipesapp.domain.repository

import com.example.recipesapp.domain.model.Meal
import com.example.recipesapp.utils.Resource

interface FavoriteRecipesRepository  {

     suspend fun getFavoriteRecipes(): List<Meal>
     suspend fun addRecipeToFavorite(meal: Meal):Resource<String,String>
     suspend fun deleteRecipeToFavorite(meal: Meal):Resource<String,String>


}