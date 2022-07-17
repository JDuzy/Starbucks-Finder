package com.example.starbucksfinder.data.remote.dtos

import com.squareup.moshi.Json

data class LocationGeometry(
    @field:Json(name = "location")
    val location: LocationDto,
    @field:Json(name = "viewport")
    val viewport: ViewportDto
)
