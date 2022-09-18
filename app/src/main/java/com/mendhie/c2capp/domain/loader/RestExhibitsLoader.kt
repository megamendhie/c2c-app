package com.mendhie.c2capp.domain.loader

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mendhie.c2capp.data.models.Exhibit
import com.mendhie.c2capp.data.remote.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RestExhibitsLoader @Inject constructor() {
    private val TAG = "RestExhibitsLoader"
    val data = MutableLiveData<List<Exhibit>>()
    val dataError = MutableLiveData<String>()

    fun getExhibitList(){
        ApiService.exhibitsLoader.getExhibitList().enqueue(object : Callback<List<Exhibit>>{
            override fun onResponse(call: Call<List<Exhibit>>, response: Response<List<Exhibit>>) {
                Log.i(TAG, "onResponse: ${response.code()} ${response.body()}")
                if(response.code()==200 && response.body() != null)
                    data.value = response.body()!!
                else
                    dataError.value = "Unable to load data: Error ${response.code()}"

            }

            override fun onFailure(call: Call<List<Exhibit>>, t: Throwable) {
                Log.i(TAG, "onFailure: ${t.localizedMessage}")
                dataError.value = "Unable to load data"
            }
        })
    }
}