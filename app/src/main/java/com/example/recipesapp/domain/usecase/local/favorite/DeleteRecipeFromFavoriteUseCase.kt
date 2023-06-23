package com.example.recipesapp.domain.usecase.local.favorite

import com.example.recipesapp.domain.model.Meal
import com.example.recipesapp.domain.repository.FavoriteRecipesRepository
import javax.inject.Inject

class DeleteRecipeFromFavoriteUseCase @Inject constructor(
    private val favoriteRecipesRepository: FavoriteRecipesRepository
) {
    suspend operator fun invoke(mealDto: Meal){
        return favoriteRecipesRepository.deleteRecipeToFavorite(mealDto)
    }
}