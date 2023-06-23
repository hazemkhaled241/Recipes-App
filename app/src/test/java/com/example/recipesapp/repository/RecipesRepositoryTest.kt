package com.example.recipesapp.repository


import com.example.recipesapp.data.network.RecipesApi
import com.example.recipesapp.data.repository.RecipesRepositoryImp
import com.example.recipesapp.domain.model.Meal
import com.example.recipesapp.domain.repository.RecipesRepository
import com.example.recipesapp.utils.Resource
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import retrofit2.Response


class RecipesRepositoryTest {

    private val recipesApi: RecipesApi = mockk()
    private val repo: RecipesRepository = RecipesRepositoryImp(api = recipesApi)

    @Test
    fun getRecipesSuccessfully() = runBlocking {
        // Arrange
        coEvery { recipesApi.getAllRecipes() } returns (
                Response.success(mealDtoList)
                )
        // Act
        val result = repo.getRecipes()

        // Assert
        val expectedArticles = Resource.Success(mealsList)
        assertEquals(expectedArticles, result)
    }

    @Test
    fun failedToGetRecipesAndReturnNull() = runBlocking {
        // Arrange
        coEvery { recipesApi.getAllRecipes() } returns (
                Response.success(null)
                )
        // Act
        val result = repo.getRecipes()

        // Assert
        val expectedArticles = Resource.Success(emptyList<Meal>())
        assertEquals(expectedArticles, result)
    }

}