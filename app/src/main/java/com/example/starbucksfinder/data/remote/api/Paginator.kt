package com.example.starbucksfinder.data.remote.api

interface Paginator<Key, Item> {

    suspend fun loadNextItems()

    fun reset()
}