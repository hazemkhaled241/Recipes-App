package com.example.recipesapp.data.repository

import com.example.recipesapp.domain.repository.LoginRepository
import com.example.recipesapp.utils.Resource

class LoginRepositoryImp:LoginRepository {
    override fun login(email: String, password: String): Resource<String, String> {
        TODO("Not yet implemented")
    }
}