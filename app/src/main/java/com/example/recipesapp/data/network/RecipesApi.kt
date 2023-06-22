package com.example.recipesapp.data.network


import com.example.recipesapp.data.network.dto.MealDto
import com.example.recipesapp.utils.Constants.Companion.END_POINT
import retrofit2.Response
import retrofit2.http.GET


interface RecipesApi {
    @GET(END_POINT)
    suspend fun getAllRecipes():Response<List<MealDto>>

}