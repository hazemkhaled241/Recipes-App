package com.example.recipesapp.data.repository

import com.example.recipesapp.data.local.dao.RecipeDao
import com.example.recipesapp.data.local.entities.MealEntity

class FakeRecipeDao : RecipeDao {

    private val meals = arrayListOf<MealEntity>()

    override suspend fun getAllRecipes(): List<MealEntity> {
        return meals
    }

    override suspend fun insert(mealEntity: MealEntity) {
        meals.add(mealEntity)
    }

    override suspend fun delete(mealEntity: MealEntity) {
        meals.remove(mealEntity)
    }

    fun setMeals(meals: List<MealEntity>) {
        this.meals.addAll(meals)
    }
}