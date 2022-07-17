package com.example.starbucksfinder.data.remote.dtos

import com.squareup.moshi.Json

data class OpeningHoursDto(
    @field:Json(name = "open_now")
    val isOpenNow: Boolean?
)
