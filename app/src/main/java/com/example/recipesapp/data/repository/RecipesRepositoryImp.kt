package com.example.recipesapp.data.repository

import com.example.recipesapp.data.mapper.toMeal
import com.example.recipesapp.data.network.RecipesApi
import com.example.recipesapp.domain.model.Meal
import com.example.recipesapp.domain.repository.RecipesRepository
import com.example.recipesapp.utils.Resource
import javax.inject.Inject

class RecipesRepositoryImp @Inject constructor(
    private val api: RecipesApi,
) :RecipesRepository{
    override suspend fun getRecipes(): Resource<List<Meal>, String> {

        return try {
            val response = api.getAllRecipes()
            return when (response.code()) {
                200 -> Resource.Success(response.body()?.map {
                    it.toMeal()
                } ?: emptyList())
                else -> Resource.Error(response.message().toString())

            }
        }catch (e:Exception){
            Resource.Error("Please Check Your Internet Connection")
        }

    }
}