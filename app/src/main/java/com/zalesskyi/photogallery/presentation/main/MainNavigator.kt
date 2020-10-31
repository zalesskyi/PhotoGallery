package com.zalesskyi.photogallery.presentation.main

import com.zalesskyi.photogallery.navigation.Navigator
import javax.inject.Inject
import javax.inject.Named

interface MainNavigator {


}

class MainNavigatorImpl
@Inject
constructor(@Named(APP_NAVIGATOR)
            private val navigator: Navigator) : MainNavigator {

    companion object {
        const val APP_NAVIGATOR = "MainNavigator.APP_NAVIGATOR"
        const val APP_NAV_NAVIGATOR = "MainNavigator.APP_NAV_NAVIGATOR"
    }
}