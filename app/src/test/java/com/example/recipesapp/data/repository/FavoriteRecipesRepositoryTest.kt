package com.example.recipesapp.data.repository

import com.example.recipesapp.data.local.entities.MealEntity
import com.example.recipesapp.data.mapper.toMeal
import com.example.recipesapp.domain.model.Meal
import com.example.recipesapp.domain.repository.FavoriteRecipesRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class FavoriteRecipesRepositoryTest {
    private val recipeDao = FakeRecipeDao()
    private val repo: FavoriteRecipesRepository = FavoriteRecipesRepositoryImp(recipeDao)
    @Test
    fun `addRecipeToFavorite inserts meal entity`() = runBlocking {
        // Given
        val mockMeal =
        Meal("test1","test","test","test","test","test","test","test","test","test","test",
        "test", arrayListOf("d","c"))
        // When
        repo.addRecipeToFavorite(mockMeal)

        // Then
        assert(
            recipeDao.getAllRecipes().contains(MealEntity("test1","test","test","test","test","test","test","test","test","test","test",
                "test", "d,c"))
        )
    }
    @Test
    fun `deleteRecipeToFavorite deletes meal entity`() = runBlocking {
        // Given
        val meal =
            MealEntity("test1","test","test","test","test","test","test","test","test","test","test",
                "test", "d,c")
        recipeDao.setMeals(listOf(meal))
        // When
            repo.deleteRecipeToFavorite(meal.toMeal())

        // Then
        assert(
            recipeDao.getAllRecipes().isEmpty())


    }

    @Test
    fun `getFavoriteRecipes returns list of meals`() = runBlocking {
        // Given
        val mealsEntities = mealsEntityList
        recipeDao.setMeals(mealsEntities)
        // When
        val result = repo.getFavoriteRecipes()
        //then
        assertEquals(result, mealsEntities.map { it.toMeal() })

    }
}
