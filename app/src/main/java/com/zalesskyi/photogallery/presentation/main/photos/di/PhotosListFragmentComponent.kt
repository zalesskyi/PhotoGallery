package com.zalesskyi.photogallery.presentation.main.photos.di

import androidx.lifecycle.ViewModel
import com.zalesskyi.photogallery.android.di.scopes.PerFragment
import com.zalesskyi.photogallery.android.di.viewmodelfactory.ViewModelKey
import com.zalesskyi.photogallery.presentation.main.photos.PhotosListFragment
import com.zalesskyi.photogallery.presentation.main.photos.PhotosListViewModelImpl
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@PerFragment
@Subcomponent(
    modules = [
        (PhotosListFragmentComponent.FragmentBindingsModule::class),
        (PhotosListFragmentComponent.FragmentModule::class),
        (PhotosListFragmentComponent.FragmentBindsModule::class)
    ]
)
interface PhotosListFragmentComponent : AndroidInjector<PhotosListFragment> {

    @Subcomponent.Factory
    abstract class Factory : AndroidInjector.Factory<PhotosListFragment>

    @Module(
        subcomponents = [
            // child fragments
        ]
    )
    abstract class FragmentBindingsModule {

        @Binds
        @IntoMap
        @ViewModelKey(PhotosListViewModelImpl::class)
        abstract fun bindViewModel(viewModel: PhotosListViewModelImpl): ViewModel
    }

    @Module
    class FragmentModule


    @Module
    interface FragmentBindsModule
}