package com.example.recipesapp.presentation.intro.splash.viewmodel

import androidx.lifecycle.ViewModel
import com.example.recipesapp.domain.usecase.local.shared_preference.GetFromSharedPreferenceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getFromSharedPreferenceUseCase: GetFromSharedPreferenceUseCase
) : ViewModel() {



    fun <T> getFromSP(key: String, clazz: Class<T>): T {
        return getFromSharedPreferenceUseCase(key, clazz)
    }
}