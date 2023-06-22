package com.example.recipesapp.data.repository

import com.example.recipesapp.data.local.dao.RecipeDao
import com.example.recipesapp.data.mapper.toMeal
import com.example.recipesapp.data.mapper.toMealEntity
import com.example.recipesapp.data.network.RecipesApi
import com.example.recipesapp.domain.model.Meal
import com.example.recipesapp.domain.repository.RecipesRepository
import com.example.recipesapp.utils.Resource
import javax.inject.Inject

class RecipesRepositoryImp @Inject constructor(
    private val api: RecipesApi,
    private val recipeDao: RecipeDao
) : RecipesRepository {

    override suspend fun getRecipes(): Resource<List<Meal>, String> {


        val response = api.getAllRecipes()
        return when (response.code()) {
            200 -> Resource.Success(response.body()?.map {
                it.toMeal()
            } ?: emptyList())
            else -> Resource.Error(response.message())


        }


    }

    override suspend fun getFavoriteRecipes(): List<Meal> {
        return try {
            recipeDao.getAllRecipes().map { it.toMeal() }

        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun addRecipeToFavorite(meal: Meal) {
        return try {
            recipeDao.insert(meal.toMealEntity())

        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun deleteRecipeToFavorite(meal: Meal) {
        return try {
            recipeDao.delete(meal.toMealEntity())

        } catch (e: Exception) {
            throw e
        }
    }

}

