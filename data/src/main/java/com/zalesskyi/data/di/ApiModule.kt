package com.zalesskyi.data.di

import com.zalesskyi.data.network.api.MediaApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiModule {

    @Singleton
    @Provides
    fun provideMediaApi(retrofit: Retrofit): MediaApi =
            retrofit.create(MediaApi::class.java)
}