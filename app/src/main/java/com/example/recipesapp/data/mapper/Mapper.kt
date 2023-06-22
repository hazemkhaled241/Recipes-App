package com.example.recipesapp.data.mapper

import com.example.recipesapp.data.local.entities.MealEntity
import com.example.recipesapp.data.network.dto.MealDto
import com.example.recipesapp.domain.model.Meal


fun MealEntity.toMeal(): Meal {
    return Meal(
        id = id,
        fats = fats,
        name = name,
        image = image,
        carbos = carbos,
        fibers = fibers,
        rating = rating,
        country = country,
        ratings = ratings,
        calories = calories,
        proteins = proteins,
        description = description,
        ingredients = ingredients.split(",").toCollection(ArrayList()),
    )
}

fun Meal.toMealEntity(): MealEntity {
    return MealEntity(
        id = id,
        fats = fats,
        name = name,
        image = image,
        carbos = carbos,
        fibers = fibers,
        rating = rating,
        country = country,
        ratings = ratings,
        calories = calories,
        proteins = proteins,
        description = description,
        ingredients = ingredients.joinToString(",")
    )
}

fun MealDto.toMeal(): Meal {
    return Meal(
        id = id!!,
        fats = fats,
        name = name,
        image = image,
        carbos = carbos,
        fibers = fibers,
        rating = rating,
        country = country,
        ratings = ratings,
        calories = calories,
        proteins = proteins,
        description = description,
        ingredients = ingredients
    )
}
