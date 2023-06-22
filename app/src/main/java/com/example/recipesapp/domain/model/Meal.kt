package com.example.recipesapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Meal(
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
    val ingredients: ArrayList<String> ,
):Parcelable
