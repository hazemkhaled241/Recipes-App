package com.example.recipesapp.domain.usecase.local.favorite

import com.example.recipesapp.domain.model.Meal
import com.example.recipesapp.domain.repository.FavoriteRecipesRepository
import com.example.recipesapp.utils.Resource
import javax.inject.Inject

class AddRecipeToFavoriteUseCase @Inject constructor(
    private val favoriteRecipesRepository: FavoriteRecipesRepository
) {
    suspend operator fun invoke(meal: Meal):Resource<String,String> {
        return favoriteRecipesRepository.addRecipeToFavorite(meal)
    }
}