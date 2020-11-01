package com.zalesskyi.photogallery.presentation.splash.di

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.zalesskyi.photogallery.android.di.scopes.PerActivity
import com.zalesskyi.photogallery.android.di.viewmodelfactory.ViewModelKey
import com.zalesskyi.photogallery.android.system.ContextHolder
import com.zalesskyi.photogallery.navigation.AppNavigator
import com.zalesskyi.photogallery.navigation.Navigator
import com.zalesskyi.photogallery.presentation.splash.SplashActivity
import com.zalesskyi.photogallery.presentation.splash.SplashNavigator
import com.zalesskyi.photogallery.presentation.splash.SplashNavigatorImpl
import com.zalesskyi.photogallery.presentation.splash.SplashViewModelImpl
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
            (SplashActivityComponent.ActivityBindsModule::class),
            (SplashActivityComponent.FragmentBindingsModule::class),
            (SplashActivityComponent.ActivityModule::class),
            (SplashActivityComponent.BindingsModule::class)
        ]
)
interface SplashActivityComponent : AndroidInjector<SplashActivity> {
    @Subcomponent.Factory
    abstract class Factory : AndroidInjector.Factory<SplashActivity>

    @Module
    interface ActivityBindsModule {

        @Binds
        @IntoMap
        @ViewModelKey(SplashViewModelImpl::class)
        fun bindSplashViewModel(viewModel: SplashViewModelImpl): ViewModel

        @Binds
        fun provideActivityModule(activity: SplashActivity): AppCompatActivity
    }

    @Module(
            subcomponents = [
            ]
    )
    abstract class FragmentBindingsModule


    @Module
    class ActivityModule {
        @Provides
        @Named(SplashNavigatorImpl.APP_NAVIGATOR)
        fun provideNavController(holder: ContextHolder): Navigator {
            return AppNavigator(holder)
        }

        @Provides
        fun provideNavigator(@Named(SplashNavigatorImpl.APP_NAVIGATOR) navigator: Navigator): SplashNavigator =
                SplashNavigatorImpl(navigator)
    }

    @Module(
            subcomponents = [

            ]
    )
    interface BindingsModule
}