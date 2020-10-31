package com.zalesskyi.photogallery.android.di.component.app

import com.zalesskyi.photogallery.presentation.main.MainActivity
import com.zalesskyi.photogallery.presentation.main.di.MainActivityComponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(
    subcomponents = [
        (MainActivityComponent::class)
    ]
)
abstract class ActivitiesBindsModule {

   /* @Binds
    @IntoMap
    @ClassKey(SplashActivity::class)
    internal abstract fun bindSplashActivityInjectorFactory(factory: SplashActivityComponent.Factory): AndroidInjector.Factory<*>
*/
    @Binds
    @IntoMap
    @ClassKey(MainActivity::class)
    internal abstract fun bindMainActivityInjectorFactory(factory: MainActivityComponent.Factory): AndroidInjector.Factory<*>
}
