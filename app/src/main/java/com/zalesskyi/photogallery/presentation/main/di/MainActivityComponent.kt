package com.zalesskyi.photogallery.presentation.main.di

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.zalesskyi.photogallery.android.di.scopes.PerActivity
import com.zalesskyi.photogallery.android.di.viewmodelfactory.ViewModelKey
import com.zalesskyi.photogallery.android.system.ContextHolder
import com.zalesskyi.photogallery.navigation.AppNavComponentsNavigator
import com.zalesskyi.photogallery.navigation.AppNavProvider
import com.zalesskyi.photogallery.navigation.AppNavigator
import com.zalesskyi.photogallery.navigation.Navigator
import com.zalesskyi.photogallery.presentation.main.MainActivity
import com.zalesskyi.photogallery.presentation.main.MainNavigator
import com.zalesskyi.photogallery.presentation.main.MainNavigatorImpl
import com.zalesskyi.photogallery.presentation.main.MainViewModelImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import javax.inject.Named

@PerActivity
@Subcomponent(
    modules = [
        (MainActivityComponent.ActivityBindsModule::class),
        (MainActivityComponent.FragmentBindingsModule::class),
        (MainActivityComponent.ActivityModule::class),
        (MainActivityComponent.BindingsModule::class)
    ]
)
interface MainActivityComponent : AndroidInjector<MainActivity> {
    @Subcomponent.Factory
    abstract class Factory : AndroidInjector.Factory<MainActivity>

    @Module
    interface ActivityBindsModule {

        @Binds
        @IntoMap
        @ViewModelKey(MainViewModelImpl::class)
        fun bindMainViewModel(viewModel: MainViewModelImpl): ViewModel

        @Binds
        fun provideActivityModule(activity: MainActivity): AppCompatActivity
    }

    @Module(
        subcomponents = [
        ]
    )
    abstract class FragmentBindingsModule


    @Module
    class ActivityModule {
        @Provides
        @Named(MainNavigatorImpl.APP_NAVIGATOR)
        fun provideNavController(holder: ContextHolder): Navigator {
            return AppNavigator(holder)
        }

        @Provides
        @Named(MainNavigatorImpl.APP_NAV_NAVIGATOR)
        fun provideAppNavController(provider: AppNavProvider,
                                 holder: ContextHolder
        ): Navigator {
            return AppNavComponentsNavigator(
                provider.getNavController()
            ) { provider.finish() }
        }

        @Provides
        fun provideNavigator(@Named(MainNavigatorImpl.APP_NAVIGATOR) navigator: Navigator): MainNavigator =
                MainNavigatorImpl(navigator)
    }

    @Module(
        subcomponents = [

        ]
    )
    interface BindingsModule
}