package com.zalesskyi.photogallery.android.di.component.app

import com.zalesskyi.data.di.DataModule
import com.zalesskyi.data.di.NetModule
import com.zalesskyi.data.di.RemoteModule
import com.zalesskyi.photogallery.App
import com.zalesskyi.photogallery.android.di.module.ApplicationModule
import com.zalesskyi.photogallery.android.di.viewmodelfactory.ActivityViewModelModule
import com.zalesskyi.photogallery.android.system.di.LifecycleModule
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        (ApplicationModule::class),
        (ActivityViewModelModule::class),
        (LifecycleModule::class),
        (AndroidSupportInjectionModule::class),
        (DataModule::class),
        (NetModule::class),
        (RemoteModule::class),
        (ActivitiesBindsModule::class),
        (ApplicationComponent.FragmentBindingsModule::class),
        (ApplicationComponent.ServiceBindingsModule::class)
    ]
)
interface ApplicationComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>() {
        abstract fun applicationModule(module: ApplicationModule): Builder
    }

    @Module(subcomponents = [])
    interface FragmentBindingsModule

    @Module(subcomponents = [])
    interface ServiceBindingsModule
}