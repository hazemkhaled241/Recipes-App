package com.example.recipesapp.domain.usecase.local

import com.example.recipesapp.data.mapper.toMeal
import com.example.recipesapp.data.repository.mealsEntityList
import com.example.recipesapp.domain.repository.FavoriteRecipesRepository
import com.example.recipesapp.domain.usecase.local.favorite.GetAllFavoriteRecipesUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetAllFavoriteRecipesUseCaseTest {
    private lateinit var useCase: GetAllFavoriteRecipesUseCase

    private val favoriteRecipesRepository: FavoriteRecipesRepository = mockk(relaxed = true)

    @Before
    fun setup() {
        useCase = GetAllFavoriteRecipesUseCase(favoriteRecipesRepository)
    }

    @Test
    fun testInvoke() = runBlocking{
        // Given
        coEvery { favoriteRecipesRepository.getFavoriteRecipes() } returns mealsEntityList.map { it.toMeal() }

        // When
        val result = useCase()

        // Then
        assertEquals(mealsEntityList.first().toMeal(), result.first())
    }
}