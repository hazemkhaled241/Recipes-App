package com.example.recipesapp.domain.usecase.local

import com.example.recipesapp.domain.model.Meal
import com.example.recipesapp.domain.repository.FavoriteRecipesRepository
import com.example.recipesapp.domain.usecase.local.favorite.DeleteRecipeFromFavoriteUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class DeleteRecipeFromFavoriteUseCaseTest {
    private lateinit var useCase: DeleteRecipeFromFavoriteUseCase

    private val favoriteRecipesRepository: FavoriteRecipesRepository = mockk(relaxed = true)

    @Before
    fun setup() {
        useCase = DeleteRecipeFromFavoriteUseCase(favoriteRecipesRepository)
    }

    @Test
    fun testInvoke() = runBlocking{
        // Given
        val meal =
            Meal("test1","test","test","test","test","test","test","test","test","test","test",
                "test", arrayListOf("d","c"))
        coEvery { favoriteRecipesRepository.deleteRecipeToFavorite(meal) } returns Unit

        // When
        useCase(meal)

        // Then
        coVerify { favoriteRecipesRepository.deleteRecipeToFavorite(meal) }
    }
}