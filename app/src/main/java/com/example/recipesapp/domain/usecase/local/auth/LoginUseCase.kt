package com.example.recipesapp.domain.usecase.local.auth

import com.example.recipesapp.domain.repository.LoginRepository
import com.example.recipesapp.utils.Resource
import com.example.recipesapp.utils.isValidEmailAndPassword
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val loginRepository: LoginRepository) {
    operator fun invoke(email:String,password:String):Resource<String,String> {
       return when (val result= isValidEmailAndPassword(email,password)) {
            is Resource.Error ->Resource.Error(result.message)
            is Resource.Success ->{
                loginRepository.login()
                Resource.Success(result.data)}

       }
    }


}