package com.example.recipesapp.domain.repository

import com.example.recipesapp.utils.Resource


interface LoginRepository {
    fun <T> getFromSharedPreference(key: String, clazz: Class<T>): T
    fun <T> saveInSharedPreference(key: String, data: T)
    fun login(): Resource<String, String>
}