package com.example.recipesapp.presentation.home.recipes.viewmodel

import com.example.recipesapp.domain.model.Meal

sealed class RecipesState{
    object Init : RecipesState()
    data class IsLoading(val isLoading: Boolean) : RecipesState()
    data class ShowError(val message: String) : RecipesState()
    data class GetAllRecipesSuccessfully(val meals: ArrayList<Meal>) : RecipesState()
}
