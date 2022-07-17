package com.example.starbucksfinder.data.remote.api

import com.example.starbucksfinder.BuildConfig
import com.example.starbucksfinder.data.remote.dtos.StarbucksShopsResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface StarbucksApi {

    @GET("maps/api/place/textsearch/json")
    suspend fun getStarbucksShops(
        @Query("query") query: String = "starbucks",
        @Query("sensor") sensor: Boolean = false,
        @Query("key") apiKey: String = BuildConfig.API_KEY,
        @Query("pageToken") pageToken: String? = null
    ) : StarbucksShopsResponseDto
}