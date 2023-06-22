package com.example.recipesapp.domain.usecase.remote.recipes

import com.example.recipesapp.domain.model.Meal
import com.example.recipesapp.domain.repository.RecipesRepository
import com.example.recipesapp.utils.Resource
import javax.inject.Inject

class GetAllRecipesUseCase @Inject constructor(
    private val recipesRepository: RecipesRepository
) {
    suspend operator fun invoke():Resource<List<Meal>,String>{
        return recipesRepository.getRecipes()
    }
}