package com.example.recipesapp.data.local.dao

import androidx.room.*
import com.example.recipesapp.data.local.dto.MealDto
@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(mealDto: MealDto)

    @Query(value = "SELECT * FROM recipes_table ORDER BY id ASC")
    suspend fun getAllRecipes(): List<MealDto>

    @Delete
    suspend fun delete(mealDto: MealDto)
}