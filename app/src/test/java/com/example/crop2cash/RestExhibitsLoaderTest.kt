package com.example.crop2cash

import android.util.Log
import com.example.crop2cash.di.DaggerRealExhibitsComponent
import org.junit.Assert.assertEquals
import org.junit.Test
import retrofit2.Retrofit

class RestExhibitsLoaderTest {

    @Test
    fun testRestExhibitsLoader(){

        var exhibitsComponent = DaggerRealExhibitsComponent.create()

        val retrofit: Retrofit? = exhibitsComponent.getRetrofitInstance()


        val BASE_URL = "https://my-json-server.typicode.com"
        //Assert that, Retrofit's base url matches to our BASE_URL
        assert(retrofit?.baseUrl()?.toUrl().toString() == BASE_URL)
    }

}