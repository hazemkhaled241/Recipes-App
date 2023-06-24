package com.example.recipesapp.domain.usecase.remote

import com.example.recipesapp.data.repository.mealsList
import com.example.recipesapp.domain.repository.RecipesRepository
import com.example.recipesapp.domain.usecase.remote.recipes.GetAllRecipesUseCase
import com.example.recipesapp.utils.Resource
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class GetAllRecipesUseCaseTest {
    private val recipesRepository: RecipesRepository = mockk()
    private val fetchNewsUseCase = GetAllRecipesUseCase(recipesRepository)

    @Test
    fun `when invoke is called and return a list Meals`() =
        runBlocking {
            // Given
            val expectedArticles = Resource.Success(mealsList)
            coEvery { recipesRepository.getRecipes() } returns expectedArticles

            // When
            val result = fetchNewsUseCase()

            // Then
            assertEquals(expectedArticles, result)
            }

@Test
fun `when invoke is called and return an error`() =
    runBlocking {
        // Given
        val error = Resource.Error("Error")
        coEvery { recipesRepository.getRecipes() } returns error

        // When
        val result = fetchNewsUseCase()

        // Then
        assertEquals(error, result)
    }


}