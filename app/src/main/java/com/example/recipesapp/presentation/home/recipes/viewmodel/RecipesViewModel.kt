package com.example.recipesapp.presentation.home.recipes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipesapp.domain.usecase.remote.recipes.GetAllRecipesUseCase
import com.example.recipesapp.utils.DispatcherProvider
import com.example.recipesapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipesViewModel @Inject constructor(
    private val getAllRecipesUseCase: GetAllRecipesUseCase,
    private val dispatcher: DispatcherProvider
) : ViewModel() {

    private var _recipesState = MutableStateFlow<RecipesState>(RecipesState.Init)
    val recipesState = _recipesState.asStateFlow()

    fun fetchAllRecipes() {
        setLoading(true)
        viewModelScope.launch(dispatcher.io) {
            getAllRecipesUseCase().let {
                when (it) {
                    is Resource.Error -> {
                        setLoading(false)
                        delay(500)
                        showError(it.message)
                    }
                    is Resource.Success -> {
                        setLoading(false)
                        delay(500)
                        _recipesState.value =
                            RecipesState.GetAllRecipesSuccessfully(it.data )
                    }
                }
            }
        }
    }


    private fun showError(message: String) {
        _recipesState.value = RecipesState.ShowError(message)
    }

    private fun setLoading(status: Boolean) {
        when (status) {
            true -> {
                _recipesState.value = RecipesState.IsLoading(true)
            }
            false -> {
                _recipesState.value = RecipesState.IsLoading(false)
            }
        }
    }
}