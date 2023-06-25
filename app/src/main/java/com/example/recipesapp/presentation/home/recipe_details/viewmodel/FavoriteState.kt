package com.example.recipesapp.presentation.home.recipe_details.viewmodel


sealed class FavoriteState{
    object Init : FavoriteState()
    data class AddedSuccessfully(val message: String) : FavoriteState()
    data class ShowError(val message: String) : FavoriteState()
    data class DeletedSuccessfully(val message:String): FavoriteState()
}
