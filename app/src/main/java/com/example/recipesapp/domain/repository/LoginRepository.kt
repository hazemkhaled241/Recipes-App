package com.example.recipesapp.domain.repository


interface LoginRepository {
    fun <T> getFromSharedPreference(key: String, clazz: Class<T>): T
    fun <T> saveInSharedPreference(key: String, data: T)
    fun login()
}