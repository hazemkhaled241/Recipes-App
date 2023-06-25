package com.example.recipesapp.presentation.home.recipe_details.viewmodel

import app.cash.turbine.test
import com.example.recipesapp.domain.model.Meal
import com.example.recipesapp.domain.usecase.local.favorite.AddRecipeToFavoriteUseCase
import com.example.recipesapp.domain.usecase.local.favorite.DeleteRecipeFromFavoriteUseCase
import com.example.recipesapp.domain.usecase.local.favorite.GetAllFavoriteRecipesUseCase
import com.example.recipesapp.utils.MainCoroutineRule
import com.example.recipesapp.utils.Resource
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
class RecipesDetailsViewModelTest {
    private lateinit var addRecipeToFavoriteUseCase: AddRecipeToFavoriteUseCase
    private lateinit var deleteRecipeFromFavoriteUseCase: DeleteRecipeFromFavoriteUseCase
    private lateinit var getAllFavoriteRecipesUseCase: GetAllFavoriteRecipesUseCase
    private lateinit var classUnderTest: RecipeDetailsViewModel
    private lateinit var testDispatcher: TestDispatchers

    @get:Rule
    val mainDispatcherRule = MainCoroutineRule()

    @Before
    fun setup() {
        addRecipeToFavoriteUseCase = mockk(relaxed = true)
        deleteRecipeFromFavoriteUseCase = mockk(relaxed = true)
        getAllFavoriteRecipesUseCase = mockk(relaxed = true)
        testDispatcher = TestDispatchers()
        classUnderTest = RecipeDetailsViewModel(
            addRecipeToFavoriteUseCase,
            deleteRecipeFromFavoriteUseCase,
            getAllFavoriteRecipesUseCase,
            testDispatcher
        )
    }

    @Test
    fun `test addToFavorite() and return success state`() = runTest {
        // Given
        val meal =
            Meal(
                "test1",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                arrayListOf("d", "c")
            )
        coEvery { addRecipeToFavoriteUseCase(meal) } returns Resource.Success("Added successfully")

        // When
        classUnderTest.addToFavorite(meal)
         delay(10L)
        // Then
        classUnderTest.favoriteResponse.test {
            Assert.assertEquals(FavoriteState.AddedSuccessfully("Added successfully"), awaitItem())
            cancelAndConsumeRemainingEvents()
        }
    }
    @Test
    fun `test addToFavorite() and return error state`() = runTest {
        // Given
        val meal =
            Meal(
                "test1",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                arrayListOf("d", "c")
            )
        coEvery { addRecipeToFavoriteUseCase(meal) } returns Resource.Error("error")

        // When
        classUnderTest.addToFavorite(meal)
        delay(10L)
        // Then
        classUnderTest.favoriteResponse.test {
            Assert.assertEquals(FavoriteState.ShowError("error"), awaitItem())
            cancelAndConsumeRemainingEvents()
        }
    }

    @Test
    fun `test deleteFromFavorite() and return success state`() = runTest {
        // Given
        val meal =
            Meal(
                "test1",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                arrayListOf("d", "c")
            )
        coEvery { deleteRecipeFromFavoriteUseCase(meal) } returns Resource.Success("Deleted successfully")

        // When
        classUnderTest.deleteFromFavorite(meal)
        delay(10L)
        // Then
        classUnderTest.favoriteResponse.test {
            Assert.assertEquals(FavoriteState.DeletedSuccessfully("Deleted successfully"), awaitItem())
            cancelAndConsumeRemainingEvents()
        }
    }
    @Test
    fun `test deleteFromFavorite() and return error state`() = runTest {
        // Given
        val meal =
            Meal(
                "test1",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                arrayListOf("d", "c")
            )
        coEvery { deleteRecipeFromFavoriteUseCase(meal) } returns Resource.Error("error")

        // When
        classUnderTest.deleteFromFavorite(meal)
        delay(10L)
        // Then
        classUnderTest.favoriteResponse.test {
            Assert.assertEquals(FavoriteState.ShowError("error"), awaitItem())
            cancelAndConsumeRemainingEvents()
        }
    }
}