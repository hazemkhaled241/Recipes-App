package com.example.recipesapp.domain.usecase.local.favorite

import com.example.recipesapp.domain.model.Meal
import com.example.recipesapp.domain.repository.FavoriteRecipesRepository
import com.example.recipesapp.utils.Resource
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class AddRecipeToFavoriteUseCaseTest {
    private lateinit var useCase: AddRecipeToFavoriteUseCase
    private val favoriteRecipesRepository: FavoriteRecipesRepository = mockk(relaxed = true)

    @Before
    fun setup() {
        useCase = AddRecipeToFavoriteUseCase(favoriteRecipesRepository)
    }

    @Test
    fun `test invoke() function with a Fake meal`() = runBlocking{
        // Given
        val meal =
            Meal("test1","test","test","test","test","test","test","test","test","test","test",
                "test", arrayListOf("d","c"))
        coEvery { favoriteRecipesRepository.addRecipeToFavorite(meal) } returns Resource.Success("Added successfully")

        // When
        useCase(meal)

        // Then
        coVerify { favoriteRecipesRepository.addRecipeToFavorite(meal) }
    }
}