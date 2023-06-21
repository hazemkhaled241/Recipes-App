package com.example.recipesapp.presentation.home.recipes.adapter

interface OnItemClick<T> {
    fun onItemClicked(item:T,position:Int)
}