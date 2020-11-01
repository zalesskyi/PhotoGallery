package com.zalesskyi.photogallery.presentation.main.gallery.di

import androidx.lifecycle.ViewModel
import com.zalesskyi.photogallery.android.di.scopes.PerFragment
import com.zalesskyi.photogallery.android.di.viewmodelfactory.ViewModelKey
import com.zalesskyi.photogallery.presentation.main.gallery.GalleryFragment
import com.zalesskyi.photogallery.presentation.main.gallery.GalleryViewModelImpl
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@PerFragment
@Subcomponent(
    modules = [
        (GalleryFragmentComponent.FragmentBindingsModule::class),
        (GalleryFragmentComponent.FragmentModule::class),
        (GalleryFragmentComponent.FragmentBindsModule::class)
    ]
)
interface GalleryFragmentComponent : AndroidInjector<GalleryFragment> {

    @Subcomponent.Factory
    abstract class Factory : AndroidInjector.Factory<GalleryFragment>

    @Module(
        subcomponents = [
            // child fragments
        ]
    )
    abstract class FragmentBindingsModule {

        @Binds
        @IntoMap
        @ViewModelKey(GalleryViewModelImpl::class)
        abstract fun bindViewModel(viewModel: GalleryViewModelImpl): ViewModel
    }

    @Module
    class FragmentModule


    @Module
    interface FragmentBindsModule
}