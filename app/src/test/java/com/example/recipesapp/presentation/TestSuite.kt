package com.example.recipesapp.presentation

import com.example.recipesapp.presentation.home.favorite.viewmodel.FavoriteViewModelTest
import com.example.recipesapp.presentation.home.recipe_details.viewmodel.RecipesDetailsViewModelTest
import com.example.recipesapp.presentation.home.recipes.viewmodel.RecipesViewModelTest
import com.example.recipesapp.presentation.intro.login.viewmodel.LoginViewModelTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    FavoriteViewModelTest::class,
    RecipesDetailsViewModelTest::class,
    RecipesViewModelTest::class,
    LoginViewModelTest ::class,
)
class TestSuite