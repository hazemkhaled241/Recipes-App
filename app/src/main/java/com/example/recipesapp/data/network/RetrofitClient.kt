package com.example.recipesapp.data.network

import com.example.recipesapp.utils.Constants.Companion.BASE_URI
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient  {
    companion object {

        private val retrofit by lazy {
            val client = OkHttpClient.Builder()
                .callTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .build()

            Retrofit.Builder()
                .baseUrl(BASE_URI)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }

        val api by lazy {
            retrofit.create(RecipesApi::class.java)
        }
    }


}