package com.example.recipesapp.presentation.home.recipes.viewmodel

import app.cash.turbine.test
import com.example.recipesapp.data.repository.mealsList
import com.example.recipesapp.domain.usecase.remote.recipes.GetAllRecipesUseCase
import com.example.recipesapp.utils.MainCoroutineRule
import com.example.recipesapp.utils.Resource
import com.example.recipesapp.utils.TestDispatchers
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class RecipesViewModelTest{

    private lateinit var classUnderTest: RecipesViewModel
    private lateinit var getAllRecipesUseCase: GetAllRecipesUseCase
    private lateinit var testDispatcher: TestDispatchers

    @get:Rule
    val mainDispatcherRule = MainCoroutineRule()

    @Before
    fun setup() {
        testDispatcher = TestDispatchers()
        getAllRecipesUseCase = mockk(relaxed = true)
        classUnderTest = RecipesViewModel(getAllRecipesUseCase, testDispatcher)
    }
    @Test
    fun `fetchAllRecipes(), when successful call, then should return list of meals`() =
        runTest {
            // Given
            val meals = mealsList
            coEvery { getAllRecipesUseCase.invoke() } returns Resource.Success(meals)

            // When
            classUnderTest.fetchAllRecipes()
            delay(10L)

            // Then
            classUnderTest.recipesState.test {
                assertEquals(RecipesState.IsLoading(false), awaitItem())
                assertEquals(RecipesState.GetAllRecipesSuccessfully(meals), awaitItem())
                cancelAndConsumeRemainingEvents() // Cancel collecting events from the source Flow. Any events which have already been received will be returned.
            }

        }

    @Test
    fun `fetchAllRecipes(), when unsuccessful call, then should return error`() =
        runTest {
            // Given
            val error = "error"
            coEvery { getAllRecipesUseCase.invoke() } returns Resource.Error(error)

            // When
            classUnderTest.fetchAllRecipes()
            delay(10L)

            // Then
            classUnderTest.recipesState.test {
                 assertEquals(RecipesState.IsLoading(false), awaitItem())
                assertEquals(RecipesState.ShowError(error), awaitItem())
                cancelAndConsumeRemainingEvents() // Cancel collecting events from the source Flow. Any events which have already been received will be returned.
            }

        }
}