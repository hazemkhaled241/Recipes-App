package com.example.recipesapp.data.repository

import com.example.recipesapp.data.local.entities.MealEntity
import com.example.recipesapp.data.mapper.toMeal
import com.example.recipesapp.data.mapper.toMealEntity
import com.example.recipesapp.domain.model.Meal
import com.example.recipesapp.domain.repository.FavoriteRecipesRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class FavoriteRecipesRepositoryTest {
    private lateinit var recipeDao: FakeRecipeDao
    private lateinit var repo: FavoriteRecipesRepository

    @Before
    fun setUp() {
        recipeDao = FakeRecipeDao()
        repo = FavoriteRecipesRepositoryImp(recipeDao)
    }

    @Test
    fun `add recipe to favorite inserts meal entity`() = runBlocking {
        // Given
        val mockMeal =
            Meal(
                "test1",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                arrayListOf("d", "c")
            )
        // When
        repo.addRecipeToFavorite(mockMeal)

        // Then
        assert(
            recipeDao.getAllRecipes().contains(mockMeal.toMealEntity())
        )
    }

    @Test
    fun `delete recipe to favorite deletes meal entity`() = runBlocking {
        // Given
        val meal =
            MealEntity(
                "test1",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "d,c"
            )
        recipeDao.setMeals(listOf(meal))

        // When
        repo.deleteRecipeToFavorite(meal.toMeal())

        // Then
        assert(
            recipeDao.getAllRecipes().isEmpty()
        )

    }

    @Test
    fun `get favorite recipes returns list of meals`() = runBlocking {
        // Given
        val mealsEntities = mealsEntityList
        recipeDao.setMeals(mealsEntities)
        // When
        val actual = repo.getFavoriteRecipes()
        //then
        assertEquals(mealsEntities.map { it.toMeal() },actual)

    }
}
