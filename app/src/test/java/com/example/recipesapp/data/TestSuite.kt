package com.example.recipesapp.data


import com.example.recipesapp.data.repository.FavoriteRecipesRepositoryTest
import com.example.recipesapp.data.repository.LoginRepositoryTest
import com.example.recipesapp.data.repository.RecipesRepositoryTest
import org.junit.runner.RunWith
import org.junit.runners.Suite
import org.junit.runners.Suite.SuiteClasses

@RunWith(Suite::class)
@SuiteClasses(
    RecipesRepositoryTest::class,
    FavoriteRecipesRepositoryTest::class,
    LoginRepositoryTest::class
)
class TestSuite