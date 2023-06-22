package com.example.recipesapp.data.local.dao

import androidx.room.*
import com.example.recipesapp.data.local.entities.MealEntity
@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(mealEntity: MealEntity)

    @Query(value = "SELECT * FROM recipes_table ORDER BY id ASC")
    suspend fun getAllRecipes(): List<MealEntity>

    @Delete
    suspend fun delete(mealEntity: MealEntity)
}