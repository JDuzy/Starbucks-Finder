package com.example.starbucksfinder.domain.model


data class StarbucksShopsResponse(
    val nextPageToken: String?,
    val shops: List<StarbucksShop>?
)