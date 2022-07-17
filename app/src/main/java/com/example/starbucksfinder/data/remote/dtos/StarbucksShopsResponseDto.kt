package com.example.starbucksfinder.data.remote.dtos

import com.squareup.moshi.Json


data class StarbucksShopsResponseDto(
    @field:Json(name = "next_page_token")
    val nextPageToken: String?,
    @field:Json(name = "results")
    val results: List<StarbucksShopDto>?
)
