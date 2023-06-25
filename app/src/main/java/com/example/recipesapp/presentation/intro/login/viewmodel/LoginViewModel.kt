package com.example.recipesapp.presentation.intro.login.viewmodel

import androidx.lifecycle.ViewModel
import com.example.recipesapp.domain.usecase.local.auth.LoginUseCase
import com.example.recipesapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
) : ViewModel() {
    private var _loginState = MutableStateFlow<LoginState>(LoginState.Init)
    val loginState = _loginState.asStateFlow()
    fun login(email: String, password: String) {
        setLoading(true)

            loginUseCase(email, password).let {
             when (it) {
                 is Resource.Error -> {
                     setLoading(false)
                     showError(it.message)
                 }
                 is Resource.Success -> {
                     setLoading(false)
                     _loginState.value = LoginState.LoginSuccessfully(it.data)
                 }
             }
         }
     }


    private fun showError(message: String) {
        _loginState.value = LoginState.ShowError(message)


    }

    private fun setLoading(status: Boolean) {
        when (status) {
            true -> {
                _loginState.value = LoginState.IsLoading(true)
            }
            false -> {
                _loginState.value = LoginState.IsLoading(false)
            }
        }
    }

}