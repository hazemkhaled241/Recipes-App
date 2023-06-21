package com.example.recipesapp.presentation.home.recipe_details.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipesapp.domain.model.Meal
import com.example.recipesapp.domain.usecase.local.favorite.AddRecipeToFavoriteUseCase
import com.example.recipesapp.domain.usecase.local.favorite.DeleteRecipeFromFavoriteUseCase
import com.example.recipesapp.domain.usecase.local.favorite.GetAllFavoriteRecipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class RecipeDetailsViewModel @Inject constructor(
    private val addRecipeToFavoriteUseCase: AddRecipeToFavoriteUseCase,
    private val deleteRecipeFromFavoriteUseCase: DeleteRecipeFromFavoriteUseCase,
    private val getAllFavoriteRecipesUseCase: GetAllFavoriteRecipesUseCase
) :ViewModel(){
    private val _recipeResponse = MutableStateFlow<List<Meal>?>(null)
    val recipeResponse: StateFlow<List<Meal>?> get() = _recipeResponse
    fun addToFavorite(meal: Meal) {
        viewModelScope.launch {
            addRecipeToFavoriteUseCase(meal)
        }
    }

    fun deleteFromFavorite(meal: Meal) {
        viewModelScope.launch {
            deleteRecipeFromFavoriteUseCase(meal)
        }
    }
    fun getAllFavoriteRecipes() {
        viewModelScope.launch {
            _recipeResponse.value = getAllFavoriteRecipesUseCase.invoke()

        }
    }

}