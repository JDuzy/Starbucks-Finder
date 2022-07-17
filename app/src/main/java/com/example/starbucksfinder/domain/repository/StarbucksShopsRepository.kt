package com.example.starbucksfinder.domain.repository

import com.example.starbucksfinder.domain.model.StarbucksShopsResponse
import com.example.starbucksfinder.domain.util.Resource

interface StarbucksShopsRepository {

    suspend fun getStarbucksShops(pageToken: String?) : Resource<StarbucksShopsResponse>
}