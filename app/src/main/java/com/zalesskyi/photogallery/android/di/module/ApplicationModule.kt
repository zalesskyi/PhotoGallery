package com.zalesskyi.photogallery.android.di.module

import android.app.Application
import android.content.Context
import com.zalesskyi.photogallery.android.di.qualifier.AppQualifier
import com.zalesskyi.photogallery.android.system.ContextHolder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class ApplicationModule(val application: Application) {

    @Provides
    @Singleton
    @AppQualifier
    fun provideApplication(): Application = application

    @Provides
    @Singleton
    @AppQualifier
    fun provideContext(): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideContextManager(): ContextHolder = ContextHolder()
}