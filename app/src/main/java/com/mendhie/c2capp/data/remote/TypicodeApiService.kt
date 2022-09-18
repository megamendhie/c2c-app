package com.mendhie.c2capp.data.remote

import com.mendhie.c2capp.data.models.ExhibitsLoader
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://my-json-server.typicode.com/"
const val exhibit_list = "Reyst/exhibit_db/list"

val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

object ApiService{
    val exhibitsLoader: ExhibitsLoader by lazy {
        retrofit.create(ExhibitsLoader::class.java)
    }
}