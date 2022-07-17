package com.example.starbucksfinder.data.remote.dtos

import com.squareup.moshi.Json

data class StarbucksShopDto(
    @field:Json(name = "business_status")
    val businessStatus: String?,
    @field:Json(name = "formatted_address")
    val address: String?,
    @field:Json(name = "geometry")
    val geometry: LocationGeometry,
    @field:Json(name = "name")
    val name: String?, // always starbucks?
    @field:Json(name = "opening_hours")
    val openingHours: OpeningHoursDto,
    @field:Json(name = "rating")
    val rating: Float,

)
