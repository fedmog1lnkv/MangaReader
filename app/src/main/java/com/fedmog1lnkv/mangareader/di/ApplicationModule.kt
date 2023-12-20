package com.fedmog1lnkv.mangareader.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {
    @Singleton
    @Provides
    fun provideCoroutineScope() = CoroutineScope(Dispatchers.IO + SupervisorJob())

    @Singleton
    @Provides
    fun provideGson() = Gson()
}