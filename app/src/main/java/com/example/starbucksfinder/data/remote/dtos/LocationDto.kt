package com.example.starbucksfinder.data.remote.dtos

import com.squareup.moshi.Json

data class LocationDto(
    @field:Json(name = "lat")
    val lat: Double,
    @field:Json(name = "lng")
    val lng: Double,
)
