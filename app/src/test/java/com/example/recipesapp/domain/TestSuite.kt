package com.example.recipesapp.domain


import GetFromSharedPreferenceUseCaseTest
import com.example.recipesapp.domain.usecase.local.auth.LoginUseCaseTest
import com.example.recipesapp.domain.usecase.local.favorite.AddRecipeToFavoriteUseCaseTest
import com.example.recipesapp.domain.usecase.local.favorite.DeleteRecipeFromFavoriteUseCaseTest
import com.example.recipesapp.domain.usecase.local.favorite.GetAllFavoriteRecipesUseCaseTest
import com.example.recipesapp.domain.usecase.remote.GetAllRecipesUseCaseTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    LoginUseCaseTest::class,
    AddRecipeToFavoriteUseCaseTest::class,
    DeleteRecipeFromFavoriteUseCaseTest::class,
    GetAllFavoriteRecipesUseCaseTest ::class,
    GetFromSharedPreferenceUseCaseTest ::class,
    GetAllRecipesUseCaseTest ::class
)
class TestSuite