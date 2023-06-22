package com.example.recipesapp.domain.usecase.local.shared_preference

import com.example.recipesapp.domain.repository.LoginRepository
import javax.inject.Inject

class GetFromSharedPreferenceUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {
    operator fun <T> invoke(key: String, clazz: Class<T>): T {
        return loginRepository.getFromSharedPreference(key, clazz)
    }
}