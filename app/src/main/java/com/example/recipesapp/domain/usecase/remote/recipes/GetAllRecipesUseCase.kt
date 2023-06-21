package com.example.recipesapp.domain.usecase.remote.recipes

import com.example.recipesapp.data.repository.RecipesRepositoryImp
import com.example.recipesapp.domain.model.Meal
import com.example.recipesapp.utils.Resource
import javax.inject.Inject

class GetAllRecipesUseCase @Inject constructor(
    private val recipesRepositoryImp: RecipesRepositoryImp
) {
    suspend operator fun invoke():Resource<List<Meal>,String>{
        return recipesRepositoryImp.getRecipes()
    }
}