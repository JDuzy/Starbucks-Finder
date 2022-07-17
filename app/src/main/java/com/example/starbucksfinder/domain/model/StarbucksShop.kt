package com.example.starbucksfinder.domain.model


data class StarbucksShop(
    val businessStatus: String?,
    val address: String?,
    val isOpen: Boolean?,
    val location: Location?,
    val viewport: Viewport?,
    val rating: Float?,
)
