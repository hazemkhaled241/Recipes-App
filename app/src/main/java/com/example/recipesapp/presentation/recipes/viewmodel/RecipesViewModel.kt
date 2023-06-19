package com.example.recipesapp.presentation.recipes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipesapp.domain.model.Meal
import com.example.recipesapp.domain.usecase.recipes.GetAllRecipesUseCase
import com.example.recipesapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RecipesViewModel @Inject constructor(
private val getAllRecipesUseCase: GetAllRecipesUseCase
):ViewModel() {

    private var _recipesState = MutableStateFlow<RecipesState>(RecipesState.Init)
    val recipesState = _recipesState.asStateFlow()

    fun fetchAllRecipes() {
        setLoading(true)
        viewModelScope.launch(Dispatchers.IO) {
            getAllRecipesUseCase().let {
                when (it) {
                    is Resource.Error -> {
                        withContext(Dispatchers.Main) {
                            setLoading(false)
                            showError(it.message)
                        }
                    }
                    is Resource.Success -> {
                        withContext(Dispatchers.Main) {
                            setLoading(false)
                        }
                        _recipesState.value = RecipesState.GetAllRecipesSuccessfully(it.data as ArrayList<Meal>)
                    }
                }
            }
        }
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

    private fun showError(message: String) {
                _recipesState.value = RecipesState.ShowError(message)


    }
}