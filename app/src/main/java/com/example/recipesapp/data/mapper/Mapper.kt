package com.example.recipesapp.data.mapper

import com.example.recipesapp.data.local.dto.MealDto
import com.example.recipesapp.domain.model.Meal


fun Meal.toMealDto(): MealDto {
    return MealDto(
        id = id!!,
        fats = fats,
        name = name,
        time = time,
        image = image,
        weeks = weeks.joinToString(","),
        carbos = carbos,
        fibers = fibers,
        rating = rating,
        country = country,
        ratings = ratings,
        calories = calories,
        headline = headline,
        keywords = keywords.joinToString(","),
        products = products.joinToString(","),
        proteins = proteins,
        favorites = favorites,
        difficulty = difficulty,
        description = description,
        highlighted = highlighted,
        ingredients = ingredients.joinToString(","),
        incompatibilities = incompatibilities,
        deliverableIngredients = deliverableIngredients.joinToString(","),
        undeliverableIngredients = undeliverableIngredients.joinToString(",")
    )
}

fun MealDto.toMeal(): Meal {
    return Meal(
        id = id,
        fats = fats,
        name = name,
        time = time,
        image = image,
        weeks = weeks.split(",").toCollection(ArrayList()),
        carbos = carbos,
        fibers = fibers,
        rating = rating,
        country = country,
        ratings = ratings,
        calories = calories,
        headline = headline,
        keywords = keywords.split(",").toCollection(ArrayList()),
        products = products.split(",").toCollection(ArrayList()),
        proteins = proteins,
        favorites = favorites,
        difficulty = difficulty,
        description = description,
        highlighted = highlighted,
        ingredients = ingredients.split(",").toCollection(ArrayList()),
        incompatibilities = incompatibilities,
        deliverableIngredients = deliverableIngredients.split(",").toCollection(ArrayList()),
        undeliverableIngredients = undeliverableIngredients.split(",").toCollection(ArrayList())
    )
}
