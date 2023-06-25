package com.example.recipesapp.data.repository

import com.example.recipesapp.domain.repository.LoginRepository
import com.example.recipesapp.utils.Constants
import com.example.recipesapp.utils.Resource
import com.example.recipesapp.utils.SharedPrefs
import javax.inject.Inject

class LoginRepositoryImp @Inject constructor(
    private val sharedPrefs: SharedPrefs,
):LoginRepository {
    override fun <T> saveInSharedPreference(key: String, data: T) {
        sharedPrefs.put(key, data)

    }

    override fun login():Resource<String,String> {
        saveInSharedPreference(Constants.IS_LOGGED_IN_KEY,true)
        return Resource.Success("Logged In Successfully")
    }

    override fun <T> getFromSharedPreference(key: String, clazz: Class<T>): T {
        return sharedPrefs.get(key, clazz)
    }

}