package com.mendhie.c2capp.data.remote

import org.junit.Test
import retrofit2.Retrofit

class RetrofitTest {

    /**
     * Test the BASE URL is actually correct
     */
    @Test
    fun testRetrofitInstance(){
        val instance: Retrofit = retrofit

        assert(instance.baseUrl().url().toString() == "https://my-json-server.typicode.com/")
    }

}