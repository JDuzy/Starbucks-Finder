package com.example.starbucksfinder.presentation.ui.shoplist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starbucksfinder.data.remote.api.DefaultPaginator
import com.example.starbucksfinder.domain.model.StarbucksShop
import com.example.starbucksfinder.domain.repository.StarbucksShopsRepository
import com.example.starbucksfinder.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShopListViewModel @Inject constructor(
    private val repository: StarbucksShopsRepository,
) : ViewModel() {

    var state by mutableStateOf(ShopListState())
    var nextPageKey: String? = null

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        state = state.copy(
            error = throwable.message
        )
    }

    private val paginator = DefaultPaginator<String?, StarbucksShop>(
        initialKey = null,
        onLoadUpdated = {
            state = state.copy(isLoading = it)
        },
        onRequest = { nextKey ->
            getStarbucksShops(nextKey)
        },
        getNextKey = {
            nextPageKey
        },
        onError = {
            state = state.copy(
                error = it?.localizedMessage
            )
        },
        onSuccess = { items, nextKey ->
            state = state.copy(
                endReached = items.isEmpty() || state.shops?.equals(items) ?: false,
                shops = state.shops?.plus(items)
            )
            nextPageKey = nextKey
        }
    )

    private suspend fun getStarbucksShops(nextKey: String?): Result<List<StarbucksShop>> {
        state = state.copy(
            isLoading = true,
            error = null
        )
        when (val result = repository.getStarbucksShops(
            nextKey
        )) {
            is Resource.Success -> {
                nextPageKey = result.data?.nextPageToken
                state = state.copy(
                    isLoading = false,
                    error = null
                )
                result.data?.shops?.let { return Result.success(it) } ?: return Result.failure(
                    Exception(result.message)
                )
            }
            is Resource.Error -> {
                state = state.copy(
                    shops = null,
                    isLoading = false,
                    error = result.message
                )
                return Result.failure(Exception(result.message))
            }
        }
    }

    fun loadNextShops() {
        viewModelScope.launch(Dispatchers.Main + coroutineExceptionHandler) {
            paginator.loadNextItems()
        }
    }


    fun shouldFetchMoreShops(actualIndex: Int): Boolean {
        state.shops?.let { shops ->
            return (actualIndex >= shops.lastIndex && !state.endReached && !state.isLoading)
        }
        return false
    }
}