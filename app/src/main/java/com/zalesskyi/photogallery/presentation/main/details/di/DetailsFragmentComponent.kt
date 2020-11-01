package com.zalesskyi.photogallery.presentation.main.details.di

import androidx.lifecycle.ViewModel
import com.zalesskyi.photogallery.android.di.scopes.PerFragment
import com.zalesskyi.photogallery.android.di.viewmodelfactory.ViewModelKey
import com.zalesskyi.photogallery.presentation.main.details.DetailsFragment
import com.zalesskyi.photogallery.presentation.main.details.DetailsViewModelImpl
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@PerFragment
@Subcomponent(
    modules = [
        (DetailsFragmentComponent.FragmentBindingsModule::class),
        (DetailsFragmentComponent.FragmentModule::class),
        (DetailsFragmentComponent.FragmentBindsModule::class)
    ]
)
interface DetailsFragmentComponent : AndroidInjector<DetailsFragment> {

    @Subcomponent.Factory
    abstract class Factory : AndroidInjector.Factory<DetailsFragment>

    @Module(
        subcomponents = [
            // child fragments
        ]
    )
    abstract class FragmentBindingsModule {

        @Binds
        @IntoMap
        @ViewModelKey(DetailsViewModelImpl::class)
        abstract fun bindViewModel(viewModel: DetailsViewModelImpl): ViewModel
    }

    @Module
    class FragmentModule

    @Module
    interface FragmentBindsModule
}