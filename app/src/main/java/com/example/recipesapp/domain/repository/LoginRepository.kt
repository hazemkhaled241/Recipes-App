package com.example.recipesapp.domain.repository

import com.example.recipesapp.utils.Resource

interface LoginRepository {
    fun login(email:String,password:String): Resource<String,String>
}