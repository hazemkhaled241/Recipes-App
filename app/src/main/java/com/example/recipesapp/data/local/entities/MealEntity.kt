package com.example.recipesapp.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes_table")

data class MealEntity(
    @PrimaryKey
    val id: String ,
    val fats: String? ,
    val name: String? ,
    val image: String? ,
    val carbos: String? ,
    val fibers: String? ,
    val rating: String? ,
    val country: String? ,
    val ratings: String? ,
    val calories: String? ,
    val proteins: String? ,
    val description: String? ,
    val ingredients: String ,


)