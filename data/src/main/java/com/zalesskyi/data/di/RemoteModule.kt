package com.zalesskyi.data.di

import com.zalesskyi.data.datasource.MediaRemoteDataSource
import com.zalesskyi.data.datasource.MediaRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RemoteModule {

    @Binds
    @Singleton
    abstract fun provideMediaRemote(remote: MediaRemoteDataSourceImpl): MediaRemoteDataSource
}