package com.example.recipesapp.data.repository


import com.example.recipesapp.data.network.RecipesApi
import com.example.recipesapp.data.network.dto.MealDto
import com.example.recipesapp.domain.model.Meal
import com.example.recipesapp.domain.repository.RecipesRepository
import com.example.recipesapp.utils.Resource
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.assertEquals
import org.junit.Test
import retrofit2.Response


class RecipesRepositoryTest {

    private val recipesApi: RecipesApi = mockk()
    private val repo: RecipesRepository = RecipesRepositoryImp(api = recipesApi)

    @Test
    fun `getRecipes returns success resource when API call is successful`() = runBlocking {
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
    fun `getRecipes returns error resource when API return null`() = runBlocking {
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

    @Test
    fun `getRecipes returns error resource when API call fails`() = runBlocking {
        // Given
        val errorResponse = Response.error<List<MealDto>>(
            404,
            "Not found".toResponseBody()
        )
        coEvery { recipesApi.getAllRecipes() } returns errorResponse

        // When
        val result = repo.getRecipes()

        // Then
        val expected = Resource.Error(errorResponse.message())
        assertEquals(expected, result)
    }

}