package com.example.recipesapp.presentation.home.recipe_details.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipesapp.domain.model.Meal
import com.example.recipesapp.domain.usecase.local.favorite.AddRecipeToFavoriteUseCase
import com.example.recipesapp.domain.usecase.local.favorite.DeleteRecipeFromFavoriteUseCase
import com.example.recipesapp.domain.usecase.local.favorite.GetAllFavoriteRecipesUseCase
import com.example.recipesapp.utils.DispatcherProvider
import com.example.recipesapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class RecipeDetailsViewModel @Inject constructor(
    private val addRecipeToFavoriteUseCase: AddRecipeToFavoriteUseCase,
    private val deleteRecipeFromFavoriteUseCase: DeleteRecipeFromFavoriteUseCase,
    private val getAllFavoriteRecipesUseCase: GetAllFavoriteRecipesUseCase,
    private val dispatcherProvider: DispatcherProvider
) :ViewModel(){
    private val _recipeResponse = MutableStateFlow<List<Meal>?>(null)
    val recipeResponse: StateFlow<List<Meal>?> get() = _recipeResponse

    private val _favoriteResponse = MutableStateFlow<FavoriteState>(FavoriteState.Init)
    val favoriteResponse: StateFlow<FavoriteState> get() = _favoriteResponse
    fun addToFavorite(meal: Meal) {

        viewModelScope.launch(dispatcherProvider.io) {
            addRecipeToFavoriteUseCase(meal).let {
                when(it){
                    is Resource.Error -> _favoriteResponse.value=FavoriteState.ShowError(it.message)
                    is Resource.Success ->_favoriteResponse.value=FavoriteState.AddedSuccessfully(it.data)

                }
            }
        }
    }

    fun deleteFromFavorite(meal: Meal) {
        viewModelScope.launch(dispatcherProvider.io) {
            deleteRecipeFromFavoriteUseCase(meal).let {
                when(it){
                    is Resource.Error -> _favoriteResponse.value=FavoriteState.ShowError(it.message)
                    is Resource.Success ->_favoriteResponse.value=FavoriteState.DeletedSuccessfully(it.data)

                }
            }

        }
    }
    fun getAllFavoriteRecipes() {
        viewModelScope.launch(dispatcherProvider.io) {
            _recipeResponse.value = getAllFavoriteRecipesUseCase.invoke()

        }
    }

}