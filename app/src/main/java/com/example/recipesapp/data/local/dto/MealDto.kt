package com.example.recipesapp.data.local.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes_table")

data class MealDto(
    @PrimaryKey
    val id: String ,
    val fats: String? ,
    val name: String? ,
    val time: String? ,
    val image: String? ,
    val weeks: String ,
    val carbos: String? ,
    val fibers: String? ,
    val rating: String? ,
    val country: String? ,
    val ratings: String? ,
    val calories: String? ,
    val headline: String? ,
    val keywords: String ,
    val products: String ,
    val proteins: String? ,
    val favorites: Int? ,
    val difficulty: Int? ,
    val description: String? ,
    val highlighted: Boolean? ,
    val ingredients: String ,
    val incompatibilities: String? ,
    val deliverableIngredients: String ,
    val undeliverableIngredients: String

)