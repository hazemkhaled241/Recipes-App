package com.example.recipesapp.repository

import com.example.recipesapp.data.local.entities.MealEntity
import com.example.recipesapp.data.network.dto.MealDto
import com.example.recipesapp.domain.model.Meal

val mealDtoList = listOf(
    MealDto(
        id = "533143aaff604d567f8b4571",
        fats = "8 g",
        name = "Crispy Fish Goujons ",
        time = "PT35M",
        image = "https://img.hellofresh.com/w_1080,f_webp,q_auto/hellofresh_s3/image/zartes-kokos-fischfilet-76aba609.jpg",
        weeks = arrayListOf("2014-W20"),
        carbos = "47 g",
        fibers = "",
        rating = null,
        country = "GB",
        ratings = null,
        calories = "516 kcal",
        headline = "with Sweet Potato Wedges and Minted Snap Peas",
        keywords = arrayListOf(""),
        products = arrayListOf("family-box"),
        proteins = "43 g",
        favorites = 1,
        difficulty = 0,
        description = "There’s nothing like the simple things in life - the smell of freshly cut grass, sitting outside on a nice sunny day, spending time with friends and family. Well here is a recipe that delivers simple culinary pleasures - some nice fresh fish with a crispy crust, crunchy potato wedges and some delightfully sweet sugar snap peas flavoured with cooling mint. Slip into something comfortable and relax into a delicious dinner!",
        highlighted = true,
        ingredients = arrayListOf(
            "375g Sweet Potatoes",
            "1 Tsp Paprika",
            "2 Tbsps Parmesan Cheese",
            "1 Lemon",
            "A Few Sprigs Thyme",
            "25g Panko Breadcrumbs",
            "1 Tbsp Butter",
            "2 Cod Fillets",
            "150g Sugar Snap Peas",
            "A Few Sprigs Mint",
            "75ml Sour Cream"
        ),
        incompatibilities = null,
        deliverableIngredients = arrayListOf(
            "375g Sweet Potatoes",
            "1 Tsp Paprika",
            "2 Tbsps Parmesan Cheese",
            "1 Lemon",
            "A Few Sprigs Thyme",
            "25g Panko Breadcrumbs",
            "1 Tbsp Butter",
            "2 Cod Fillets",
            "150g Sugar Snap Peas",
            "A Few Sprigs Mint",
            "75ml Sour Cream"
        ),
        undeliverableIngredients = arrayListOf()
    ), MealDto(
        id = "53314247ff604d44808b4569",
        fats = "5 g",
        name = "Moroccan Skirt Steak ",
        time = "PT30M",
        image = "https://img.hellofresh.com/w_1080,f_webp,q_auto/hellofresh_s3/image/schwedische-frikadellen-mit-kartoffelstampf-5c8d2614.jpg",
        weeks = arrayListOf("2014-W25"),
        carbos = "26 g",
        fibers = "",
        rating = "1",
        country = "GB",
        ratings = "1",
        calories = "397 kcal",
        headline = "with Spinach and Lemon Couscous",
        keywords = arrayListOf(""),
        products = arrayListOf("classic-box"),
        proteins = "31 g",
        favorites = 13,
        difficulty = 0,
        description = "Close your eyes, open up your Ras El Hanout and inhale deeply. You are no longer standing in your kitchen. Around you are the sounds of a bustling market. Robed men sell ornate carpets and a camel nibbles affectionately at your ear.  OK, we’re pretty sure Paul McKenna’s job is safe for now, but get cooking this recipe and take dinnertime on a magic carpet ride to Casablanca! Our tip for this recipe is to take your meat out of the fridge at least 30 minutes before dinner which will allow you to cook it more evenly.",
        highlighted = true,
        ingredients = arrayListOf(
            "1 Lemon",
            "1 Fillet Skirt Steak",
            "1 Tsp Ras El Hanout",
            "1 Clove Garlic",
            "1 Spring Onion",
            "1/2 Cup Carrot",
            "1 Red Pepper",
            "150g Couscous",
            "A Handful Baby Spinach Leaves",
            "4 Tbsps Coriander"
        ),
        incompatibilities = null,
        deliverableIngredients = arrayListOf(
            "1 Lemon",
            "1 Fillet Skirt Steak",
            "1 Tsp Ras El Hanout",
            "1 Clove Garlic",
            "1 Spring Onion",
            "1/2 Cup Carrot",
            "1 Red Pepper",
            "150g Couscous",
            "A Handful Baby Spinach Leaves",
            "4 Tbsps Coriander"
        ),
    )
)

val mealsList = listOf(
    Meal(
        id = "533143aaff604d567f8b4571",
        fats = "8 g",
        name = "Crispy Fish Goujons ",
        image = "https://img.hellofresh.com/w_1080,f_webp,q_auto/hellofresh_s3/image/zartes-kokos-fischfilet-76aba609.jpg",
        carbos = "47 g",
        fibers = "",
        rating = null,
        country = "GB",
        ratings = null,
        calories = "516 kcal",
        proteins = "43 g",
        description = "There’s nothing like the simple things in life - the smell of freshly cut grass, sitting outside on a nice sunny day, spending time with friends and family. Well here is a recipe that delivers simple culinary pleasures - some nice fresh fish with a crispy crust, crunchy potato wedges and some delightfully sweet sugar snap peas flavoured with cooling mint. Slip into something comfortable and relax into a delicious dinner!",
        ingredients = arrayListOf(
            "375g Sweet Potatoes",
            "1 Tsp Paprika",
            "2 Tbsps Parmesan Cheese",
            "1 Lemon",
            "A Few Sprigs Thyme",
            "25g Panko Breadcrumbs",
            "1 Tbsp Butter",
            "2 Cod Fillets",
            "150g Sugar Snap Peas",
            "A Few Sprigs Mint",
            "75ml Sour Cream"
        ),
    ), Meal(
        id = "53314247ff604d44808b4569",
        fats = "5 g",
        name = "Moroccan Skirt Steak ",
        image = "https://img.hellofresh.com/w_1080,f_webp,q_auto/hellofresh_s3/image/schwedische-frikadellen-mit-kartoffelstampf-5c8d2614.jpg",
        carbos = "26 g",
        fibers = "",
        rating = "1",
        country = "GB",
        ratings = "1",
        calories = "397 kcal",
        proteins = "31 g",
        description = "Close your eyes, open up your Ras El Hanout and inhale deeply. You are no longer standing in your kitchen. Around you are the sounds of a bustling market. Robed men sell ornate carpets and a camel nibbles affectionately at your ear.  OK, we’re pretty sure Paul McKenna’s job is safe for now, but get cooking this recipe and take dinnertime on a magic carpet ride to Casablanca! Our tip for this recipe is to take your meat out of the fridge at least 30 minutes before dinner which will allow you to cook it more evenly.",
        ingredients = arrayListOf(
            "1 Lemon",
            "1 Fillet Skirt Steak",
            "1 Tsp Ras El Hanout",
            "1 Clove Garlic",
            "1 Spring Onion",
            "1/2 Cup Carrot",
            "1 Red Pepper",
            "150g Couscous",
            "A Handful Baby Spinach Leaves",
            "4 Tbsps Coriander"
        ),
    )
)

val mealsEntityList = listOf(
    MealEntity(
        id = "533143aaff604d567f8b4571",
        fats = "8 g",
        name = "Crispy Fish Goujons ",
        image = "https://img.hellofresh.com/w_1080,f_webp,q_auto/hellofresh_s3/image/zartes-kokos-fischfilet-76aba609.jpg",
        carbos = "47 g",
        fibers = "",
        rating = null,
        country = "GB",
        ratings = null,
        calories = "516 kcal",
        proteins = "43 g",
        description = "There’s nothing like the simple things in life - the smell of freshly cut grass, sitting outside on a nice sunny day, spending time with friends and family. Well here is a recipe that delivers simple culinary pleasures - some nice fresh fish with a crispy crust, crunchy potato wedges and some delightfully sweet sugar snap peas flavoured with cooling mint. Slip into something comfortable and relax into a delicious dinner!",
        ingredients =
        "375g Sweet Potatoes,1 Tsp Paprika,2 Tbsps Parmesan Cheese,1 LemonA Few Sprigs Thyme,25g Panko Breadcrumbs,1 Tbsp Butter,2 Cod Fillets,150g Sugar Snap Peas,A Few Sprigs Mint,75ml Sour Cream"
    ),


 MealEntity(
id = "53314247ff604d44808b4569",
fats = "5 g",
name = "Moroccan Skirt Steak ",
image = "https://img.hellofresh.com/w_1080,f_webp,q_auto/hellofresh_s3/image/schwedische-frikadellen-mit-kartoffelstampf-5c8d2614.jpg",
carbos = "26 g",
fibers = "",
rating = "1",
country = "GB",
ratings = "1",
calories = "397 kcal",
proteins = "31 g",
description = "Close your eyes, open up your Ras El Hanout and inhale deeply. You are no longer standing in your kitchen. Around you are the sounds of a bustling market. Robed men sell ornate carpets and a camel nibbles affectionately at your ear.  OK, we’re pretty sure Paul McKenna’s job is safe for now, but get cooking this recipe and take dinnertime on a magic carpet ride to Casablanca! Our tip for this recipe is to take your meat out of the fridge at least 30 minutes before dinner which will allow you to cook it more evenly.",
ingredients ="1 Lemon,1 Fillet Skirt Steak,1 Tsp Ras El Hanout,1 Clove Garlic,1 Spring Onion,1/2 Cup Carrot,1 Red Pepper,150g Couscous,A Handful Baby Spinach Leaves,4 Tbsps Coriander"
))