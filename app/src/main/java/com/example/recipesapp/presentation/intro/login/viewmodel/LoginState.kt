package com.example.recipesapp.presentation.intro.login.viewmodel

sealed class LoginState{
    object Init:LoginState()
data class LoginSuccessfully(val confirmation:String):LoginState()
data class IsLoading(val isLoading:Boolean):LoginState()
data class ShowError(val message:String):LoginState()
}
