package com.example.recipesapp.data.network.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
@Parcelize
data class MealDto(
    @SerializedName("id") var id: String? = null,
    @SerializedName("fats") var fats: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("time") var time: String? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("weeks") var weeks: ArrayList<String> = arrayListOf(),
    @SerializedName("carbos") var carbos: String? = null,
    @SerializedName("fibers") var fibers: String? = null,
    @SerializedName("rating") var rating: String? = null,
    @SerializedName("country") var country: String? = null,
    @SerializedName("ratings") var ratings: String? = null,
    @SerializedName("calories") var calories: String? = null,
    @SerializedName("headline") var headline: String? = null,
    @SerializedName("keywords") var keywords: ArrayList<String> = arrayListOf(),
    @SerializedName("products") var products: ArrayList<String> = arrayListOf(),
    @SerializedName("proteins") var proteins: String? = null,
    @SerializedName("favorites") var favorites: Int? = null,
    @SerializedName("difficulty") var difficulty: Int? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("highlighted") var highlighted: Boolean? = null,
    @SerializedName("ingredients") var ingredients: ArrayList<String> = arrayListOf(),
    @SerializedName("incompatibilities") var incompatibilities: String? = null,
    @SerializedName("deliverable_ingredients") var deliverableIngredients: ArrayList<String> = arrayListOf(),
    @SerializedName("undeliverable_ingredients") var undeliverableIngredients: ArrayList<String> = arrayListOf()
):Parcelable
