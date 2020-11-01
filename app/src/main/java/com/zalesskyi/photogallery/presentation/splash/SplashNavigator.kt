package com.zalesskyi.photogallery.presentation.splash

import com.zalesskyi.photogallery.navigation.NavDirections
import com.zalesskyi.photogallery.navigation.Navigator
import javax.inject.Inject
import javax.inject.Named

interface SplashNavigator {

    fun toMain()
}

class SplashNavigatorImpl
@Inject
constructor(@Named(APP_NAVIGATOR)
            private val navigator: Navigator) : SplashNavigator {

    companion object {

        const val APP_NAVIGATOR = "SplashNavigator.APP_NAVIGATOR"
    }

    override fun toMain() {
        navigator.navigate(NavDirections.SPLASH_TO_MAIN)
    }
}