package com.example.recipesapp.data.repository

import com.example.recipesapp.domain.repository.LoginRepository
import com.example.recipesapp.utils.SharedPrefs
import javax.inject.Inject

class LoginRepositoryImp @Inject constructor(
    private val sharedPrefs: SharedPrefs,
):LoginRepository {
    override fun <T> saveInSharedPreference(key: String, data: T) {
        sharedPrefs.put(key, data)
    }

    override fun <T> getFromSharedPreference(key: String, clazz: Class<T>): T {
        return sharedPrefs.get(key, clazz)
    }

}