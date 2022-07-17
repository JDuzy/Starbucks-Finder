package com.example.starbucksfinder.data.di

import com.example.starbucksfinder.data.repository.StarbucksShopsRepositoryImpl
import com.example.starbucksfinder.domain.repository.StarbucksShopsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindStarbucksRepository(
        starbucksShopsRepositoryImpl: StarbucksShopsRepositoryImpl
    ) : StarbucksShopsRepository
}