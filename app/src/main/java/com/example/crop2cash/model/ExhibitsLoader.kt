package com.example.crop2cash.model

import retrofit2.Call
import retrofit2.http.GET

interface ExhibitsLoader {

    @GET("/Reyst/exhibit_db/list")
    fun getExhibitList(): Call<List<Exhibit>>
}