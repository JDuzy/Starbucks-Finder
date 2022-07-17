package com.example.starbucksfinder.data.remote.dtos

import com.squareup.moshi.Json

data class ViewportDto(
    @field:Json(name = "northeast")
    val northeast: LocationDto,
    @field:Json(name = "southwest")
    val southwest: LocationDto,
)
