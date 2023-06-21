package com.example.recipesapp.presentation.home.favorite.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipesapp.domain.model.Meal
import com.example.recipesapp.domain.usecase.local.favorite.GetAllFavoriteRecipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val getAllFavoriteRecipesUseCase: GetAllFavoriteRecipesUseCase) :
    ViewModel() {
    private val _recipeResponse = MutableStateFlow<List<Meal>?>(null)
    val recipeResponse: StateFlow<List<Meal>?> get() = _recipeResponse

    fun getAllFavoriteRecipes() {
        viewModelScope.launch {
            _recipeResponse.value = getAllFavoriteRecipesUseCase.invoke()

        }
    }
}