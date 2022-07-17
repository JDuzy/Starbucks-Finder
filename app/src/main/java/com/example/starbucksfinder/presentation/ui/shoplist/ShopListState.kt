package com.example.starbucksfinder.presentation.ui.shoplist

import com.example.starbucksfinder.domain.model.StarbucksShop

data class ShopListState(
    val shops: List<StarbucksShop>? = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val endReached: Boolean = false
)
