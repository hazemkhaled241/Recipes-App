package com.example.recipesapp.data.repository

import com.example.recipesapp.data.local.dao.RecipeDao
import com.example.recipesapp.data.mapper.toMeal
import com.example.recipesapp.data.mapper.toMealEntity
import com.example.recipesapp.domain.model.Meal
import com.example.recipesapp.domain.repository.FavoriteRecipesRepository
import javax.inject.Inject

class FavoriteRecipesRepositoryImp @Inject constructor(
    private val recipeDao: RecipeDao
) : FavoriteRecipesRepository {



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

