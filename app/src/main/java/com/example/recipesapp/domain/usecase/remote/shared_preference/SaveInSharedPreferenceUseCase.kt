package com.example.recipesapp.domain.usecase.remote.shared_preference

import com.example.recipesapp.domain.repository.LoginRepository
import javax.inject.Inject

class SaveInSharedPreferenceUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {
    operator fun <T> invoke(key: String, data: T) {
        loginRepository.saveInSharedPreference(key, data)
    }
}