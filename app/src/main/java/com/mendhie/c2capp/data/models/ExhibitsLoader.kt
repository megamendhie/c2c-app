package com.mendhie.c2capp.data.models

import com.mendhie.c2capp.data.remote.exhibit_list
import retrofit2.Call
import retrofit2.http.GET

interface ExhibitsLoader {

    @GET(exhibit_list)
    fun getExhibitList(): Call<List<Exhibit>>

}