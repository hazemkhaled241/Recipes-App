package com.example.recipesapp.presentation.intro.login.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(

): ViewModel() {
private var _loginSate=MutableStateFlow<LoginState>(LoginState.Init)
 val loginState=_loginSate.asStateFlow()
    fun login() {
        TODO("Not yet implemented")
    }

}