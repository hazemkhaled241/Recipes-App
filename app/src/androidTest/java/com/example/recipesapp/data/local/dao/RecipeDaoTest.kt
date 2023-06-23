package com.example.recipesapp.data.local.dao

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.recipesapp.data.local.RecipesDataBase
import com.example.recipesapp.data.mapper.toMealEntity
import com.example.recipesapp.domain.model.Meal
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class RecipeDaoTest {
    private lateinit var recipesDataBase: RecipesDataBase
    private lateinit var recipeDao: RecipeDao

    @Before
     fun setUp() {
        recipesDataBase = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext()
            ,RecipesDataBase::class.java).allowMainThreadQueries().build()
       recipeDao=recipesDataBase.recipeDao()
    }
    @After
     fun tearDown(){
        recipesDataBase.close()
    }
    @Test
     fun insertRecipeToDatabaseTest() = runBlocking{
      val meal =Meal("test1","test","test","test","test","test","test","test","test","test","test",
         "test", arrayListOf())
        recipeDao.insert(meal.toMealEntity())
        val allRecipes = recipeDao.getAllRecipes()
        assertThat(allRecipes).contains(meal.toMealEntity())
    }

    @Test
    fun deleteRecipeFromDatabaseTest() = runBlocking{
        val meal =Meal("test1","test","test","test","test","test","test","test","test","test","test",
            "test", arrayListOf())
        recipeDao.insert(meal.toMealEntity())
        recipeDao.delete(meal.toMealEntity())
        val allRecipes = recipeDao.getAllRecipes()
        assertThat(allRecipes).doesNotContain(meal.toMealEntity())
    }
}