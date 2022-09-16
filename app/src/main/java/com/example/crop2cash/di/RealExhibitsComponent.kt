package com.example.crop2cash.di

import com.example.crop2cash.network.RestExhibitsLoader
import com.example.crop2cash.viewmodel.ExhibitsViewmodel
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [RestExhibitsLoader::class])
interface RealExhibitsComponent {

    fun getRetrofitInstance(): Retrofit?

    fun getExhibitsViewModel(): ExhibitsViewmodel
}