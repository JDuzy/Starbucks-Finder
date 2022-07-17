package com.example.starbucksfinder.data.repository

import com.example.starbucksfinder.data.remote.api.StarbucksApi
import com.example.starbucksfinder.data.mappers.toStarbucksShopResponse
import com.example.starbucksfinder.domain.model.StarbucksShopsResponse
import com.example.starbucksfinder.domain.repository.StarbucksShopsRepository
import com.example.starbucksfinder.domain.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class StarbucksShopsRepositoryImpl @Inject constructor(
    private val api: StarbucksApi
) : StarbucksShopsRepository {

    override suspend fun getStarbucksShops(pageToken: String?): Resource<StarbucksShopsResponse> =
        withContext(Dispatchers.IO) {
            return@withContext try {
                Resource.Success(
                    data = api.getStarbucksShops(pageToken = pageToken).toStarbucksShopResponse()
                )
            } catch (e: Exception) {
                e.printStackTrace()
                Resource.Error(e.message ?: "An unknown error has ocurred")
            }
        }
}
