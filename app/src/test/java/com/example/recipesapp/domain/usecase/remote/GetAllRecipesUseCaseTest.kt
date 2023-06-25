package com.example.recipesapp.domain.usecase.remote

import com.example.recipesapp.data.repository.mealsList
import com.example.recipesapp.domain.repository.RecipesRepository
import com.example.recipesapp.domain.usecase.remote.recipes.GetAllRecipesUseCase
import com.example.recipesapp.utils.Resource
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetAllRecipesUseCaseTest {
    private lateinit var recipesRepository: RecipesRepository
    private lateinit var getAllRecipesUseCase :GetAllRecipesUseCase

    @Before
    fun setUp(){
        recipesRepository= mockk(relaxed = true)
        getAllRecipesUseCase= GetAllRecipesUseCase(recipesRepository)
    }
    @Test
    fun `when invoke is called and return a list Meals`() =
        runBlocking {
            // Given
            val expected = Resource.Success(mealsList)
            coEvery { recipesRepository.getRecipes() } returns expected

            // When
            val actual = getAllRecipesUseCase()

            // Then
            assertEquals(expected, actual)
            }

@Test
fun `when invoke is called and return an error`() =
    runBlocking {
        // Given
        val expected = Resource.Error("Error")
        coEvery { recipesRepository.getRecipes() } returns expected

        // When
        val actual = getAllRecipesUseCase()

        // Then
        assertEquals(expected, actual)
    }


}