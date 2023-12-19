package com.fedmog1lnkv.mangareader.di

import com.fedmog1lnkv.mangareader.data.repository.MangaRepositoryImpl
import com.fedmog1lnkv.mangareader.data.repository.UserRepositoryImpl
import com.fedmog1lnkv.mangareader.domain.repository.MangaRepository
import com.fedmog1lnkv.mangareader.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryBindingModule {

    @Binds
    @Singleton
    fun bindUserRepository(repository: UserRepositoryImpl): UserRepository

    @Binds
    @Singleton
    fun bindMangaRepository(repository: MangaRepositoryImpl): MangaRepository
}