package com.example.recipesapp.repository

import com.example.recipesapp.data.local.dao.RecipeDao
import com.example.recipesapp.data.local.entities.MealEntity

class FakeRecipeDao : RecipeDao {

    private val meals = mutableListOf<MealEntity>()

    override suspend fun getAllRecipes(): List<MealEntity> {
        return meals
    }

    override suspend fun insert(meal: MealEntity) {
        meals.add(meal)
    }

    override suspend fun delete(meal: MealEntity) {
        meals.remove(meal)
    }

    fun setMeals(meals: List<MealEntity>) {
        this.meals.clear()
        this.meals.addAll(meals)
    }
}