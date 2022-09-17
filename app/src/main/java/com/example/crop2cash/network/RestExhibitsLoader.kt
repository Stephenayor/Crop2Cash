package com.example.crop2cash.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class RestExhibitsLoader {
    companion object retrofitInstance {

        private val retrofit: Retrofit? = null
        private val BASE_URL = "https://my-json-server.typicode.com"
        private val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        @Provides
        @Singleton
        fun provideGsonConverterFactory(): GsonConverterFactory? {
            return GsonConverterFactory.create()
        }

        @Provides
        @Singleton
        fun provideInterceptor(): OkHttpClient.Builder {
            val logger: HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS)
            val okHTTP: OkHttpClient.Builder = OkHttpClient.Builder().addInterceptor(logger)
            val interceptor = Interceptor { chain ->
                val url = chain.request().url.newBuilder().build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()
                chain.proceed(request)
            }
            return okHTTP
        }


        @Provides
        @Singleton
        fun provideMoshiConverterFactory(): MoshiConverterFactory? {
            return MoshiConverterFactory.create(moshi)
        }


        @Provides
        @Singleton
        fun provideRetrofitInstance(client: OkHttpClient.Builder, gsonConverterFactory: GsonConverterFactory?,
                                    moshiConverterFactory: MoshiConverterFactory?): Retrofit? {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .addConverterFactory(moshiConverterFactory)
                .client(client.build())
                .build()

        }
    }
}