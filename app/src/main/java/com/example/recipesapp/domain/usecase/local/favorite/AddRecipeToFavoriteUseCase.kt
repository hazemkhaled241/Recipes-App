package com.example.recipesapp.domain.usecase.local.favorite

import com.example.recipesapp.domain.model.Meal
import com.example.recipesapp.domain.repository.RecipesRepository
import javax.inject.Inject

class AddRecipeToFavoriteUseCase @Inject constructor(
    private val recipesRepository: RecipesRepository
) {
    suspend operator fun invoke(meal: Meal) {
        return recipesRepository.addRecipeToFavorite(meal)
    }
}