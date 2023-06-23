package com.example.recipesapp.domain.repository

import com.example.recipesapp.domain.model.Meal
import com.example.recipesapp.utils.Resource

interface RecipesRepository {
    suspend fun getRecipes(): Resource<List<Meal>, String>

}