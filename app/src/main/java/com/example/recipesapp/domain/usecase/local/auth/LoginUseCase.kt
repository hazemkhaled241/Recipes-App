package com.example.recipesapp.domain.usecase.local.auth

import com.example.recipesapp.utils.Resource
import com.example.recipesapp.utils.isValidEmailAndPassword
import javax.inject.Inject

class LoginUseCase @Inject constructor() {
    operator fun invoke(email:String,password:String):Resource<String,String> {
       return when (val result= isValidEmailAndPassword(email,password)) {
            is Resource.Error ->Resource.Error(result.message)
            is Resource.Success -> Resource.Success(result.data)
        }
    }
}