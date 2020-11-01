package com.zalesskyi.photogallery.android.di.viewmodelfactory

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
abstract class ActivityViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: StromeeViewModelFactory): ViewModelProvider.Factory


}