package com.example.recipesapp.presentation.home.favorite.viewmodel

import app.cash.turbine.test
import com.example.recipesapp.data.repository.mealsList
import com.example.recipesapp.domain.usecase.local.favorite.GetAllFavoriteRecipesUseCase
import com.example.recipesapp.utils.MainCoroutineRule
import com.example.recipesapp.utils.TestDispatchers
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
@OptIn(ExperimentalCoroutinesApi::class)
class FavoriteViewModelTest {
    private lateinit var classUnderTest: FavoriteViewModel
    private lateinit var getAllFavoriteRecipesUseCase: GetAllFavoriteRecipesUseCase
    private lateinit var testDispatcher: TestDispatchers

    @get:Rule
    val mainDispatcherRule = MainCoroutineRule()

    @Before
    fun setup() {
        testDispatcher = TestDispatchers()
        getAllFavoriteRecipesUseCase = mockk(relaxed = true)
        classUnderTest = FavoriteViewModel(getAllFavoriteRecipesUseCase, testDispatcher)
    }
    @Test
    fun `getAllFavoriteRecipes(), when successful call, then should return list of meals`() =
        runTest {
            // Given
            val meals = mealsList
            coEvery { getAllFavoriteRecipesUseCase.invoke() } returns meals

            // When
            classUnderTest.getAllFavoriteRecipes()
            delay(10L)

            // Then
            classUnderTest.recipeResponse.test {
                Assert.assertEquals(meals, awaitItem())
                cancelAndConsumeRemainingEvents() // Cancel collecting events from the source Flow. Any events which have already been received will be returned.
            }

        }


}