package com.example.starbucksfinder.data.mappers

import com.example.starbucksfinder.data.remote.dtos.LocationDto
import com.example.starbucksfinder.data.remote.dtos.ViewportDto
import com.example.starbucksfinder.domain.model.Location
import com.example.starbucksfinder.domain.model.Viewport

fun LocationDto.toLocation(): Location {
    return Location(
        lat = lat,
        lng = lng
    )
}

fun ViewportDto.toViewport(): Viewport {
    return Viewport(
        northeast = northeast.toLocation(),
        southwest = southwest.toLocation()
    )
}