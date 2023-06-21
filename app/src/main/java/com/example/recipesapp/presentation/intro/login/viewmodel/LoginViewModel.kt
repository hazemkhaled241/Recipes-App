package com.example.recipesapp.presentation.intro.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipesapp.domain.usecase.auth.LoginUseCase
import com.example.recipesapp.domain.usecase.shared_preference.SaveInSharedPreferenceUseCase
import com.example.recipesapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val saveInSharedPreferenceUseCase: SaveInSharedPreferenceUseCase
) : ViewModel() {
    private var _loginState = MutableStateFlow<LoginState>(LoginState.Init)
    val loginState = _loginState.asStateFlow()
    fun login(email: String, password: String) {
        setLoading(true)
        viewModelScope.launch {
         loginUseCase(email, password).let {
             when (it) {
                 is Resource.Error -> {
                     setLoading(false)
                     delay(500)
                     showError(it.message)
                 }
                 is Resource.Success -> {
                     setLoading(false)
                     delay(500)
                     _loginState.value = LoginState.LoginSuccessfully(it.data)
                 }
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
     fun <T> saveInSP(key: String, data: T) {
         saveInSharedPreferenceUseCase(key, data)
     }
}