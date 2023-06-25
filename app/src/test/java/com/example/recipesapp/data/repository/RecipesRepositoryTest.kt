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
import org.junit.Before
import org.junit.Test
import retrofit2.Response


class RecipesRepositoryTest {

    private lateinit var recipesApi: RecipesApi
    private lateinit var repo: RecipesRepository

    @Before
    fun setUp() {
        recipesApi = mockk()
        repo = RecipesRepositoryImp(api = recipesApi)
    }

    @Test
    fun `getRecipes returns success resource when API call is successful`() = runBlocking {
        // Given
        coEvery { recipesApi.getAllRecipes() } returns (
                Response.success(mealDtoList)
                )
        val expected = Resource.Success(mealsList)

        // When
        val actual = repo.getRecipes()

        // Then
        assertEquals(expected, actual)
    }

    @Test
    fun `getRecipes returns error resource when API return null`() = runBlocking {
        // Given
        coEvery { recipesApi.getAllRecipes() } returns (
                Response.success(null)
                )
        val expected = Resource.Success(emptyList<Meal>())
        // When
        val actual = repo.getRecipes()
        // Then
        assertEquals(expected, actual)
    }

    @Test
    fun `getRecipes returns error resource when API call fails`() = runBlocking {
        // Given
        val errorResponse = Response.error<List<MealDto>>(
            404,
            "Not found".toResponseBody()
        )
        val expected = Resource.Error(errorResponse.message())
        coEvery { recipesApi.getAllRecipes() } returns errorResponse

        // When
        val actual = repo.getRecipes()

        // Then
        assertEquals(expected, actual)
    }

    @Test
    fun `getRecipes(),when there is an exception,then returns error resource with error message`() =
        runBlocking {
            // Given
            val expected = Resource.Error("Error")
            coEvery { recipesApi.getAllRecipes() } throws Exception("Error")

            // When
            val actual = repo.getRecipes()

            // Then
            assertEquals(expected, actual)
        }

}