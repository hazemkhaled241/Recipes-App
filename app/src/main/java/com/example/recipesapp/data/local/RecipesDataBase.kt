package com.example.recipesapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.recipesapp.data.local.dao.RecipeDao
import com.example.recipesapp.data.local.dto.MealDto

@Database(entities = [MealDto::class], version = 1, exportSchema = false)
abstract class RecipesDataBase:RoomDatabase() {

    abstract fun recipeDao(): RecipeDao
    companion object{
        @Volatile

        private var INSTANCE: RecipesDataBase?=null
        fun getDataBase(context: Context): RecipesDataBase {
            val tempInstance= INSTANCE
            if(tempInstance!=null) {
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RecipesDataBase::class.java,
                    "country"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}