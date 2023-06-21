package com.example.recipesapp.domain.usecase.local.favorite

import com.example.recipesapp.data.repository.RecipesRepositoryImp
import com.example.recipesapp.domain.model.Meal
import javax.inject.Inject

class AddRecipeToFavoriteUseCase @Inject constructor(
    private val recipesRepositoryImp: RecipesRepositoryImp
) {
    suspend operator fun invoke(meal: Meal) {
        return recipesRepositoryImp.addRecipeToFavorite(meal)
    }
}