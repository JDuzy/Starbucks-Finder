package com.example.starbucksfinder.data.di

import com.example.starbucksfinder.data.remote.api.StarbucksApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideStarbucksApi(): StarbucksApi{
        val logging = HttpLoggingInterceptor()
// set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val httpClient = OkHttpClient.Builder()
// add your other interceptors …
// add logging as last interceptor
        httpClient.addInterceptor(logging)
        return Retrofit.Builder()
            .baseUrl("https://maps.googleapis.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(httpClient.build())
            .build()
            .create()
    }
}