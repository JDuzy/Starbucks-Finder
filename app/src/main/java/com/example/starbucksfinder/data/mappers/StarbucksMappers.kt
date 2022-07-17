package com.example.starbucksfinder.data.mappers

import com.example.starbucksfinder.data.remote.dtos.StarbucksShopDto
import com.example.starbucksfinder.data.remote.dtos.StarbucksShopsResponseDto
import com.example.starbucksfinder.domain.model.StarbucksShop
import com.example.starbucksfinder.domain.model.StarbucksShopsResponse

fun StarbucksShopDto.toStarbucksShop(): StarbucksShop {
    return StarbucksShop(
        businessStatus = businessStatus,
        address = address,
        isOpen = openingHours?.isOpenNow,
        location = geometry?.location?.toLocation(),
        viewport = geometry?.viewport?.toViewport(),
        rating = rating
    )
}

fun StarbucksShopsResponseDto.toStarbucksShopResponse(): StarbucksShopsResponse {
    return StarbucksShopsResponse(nextPageToken = nextPageToken,
        shops = results?.map { it.toStarbucksShop() }
    )
}
