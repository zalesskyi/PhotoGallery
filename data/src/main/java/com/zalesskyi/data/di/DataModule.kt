package com.zalesskyi.data.di

import com.zalesskyi.data.repository.MediaDataRepository
import com.zalesskyi.domain.repository.MediaRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

    @Binds
    abstract fun provideMediaRepository(repository: MediaDataRepository): MediaRepository
}