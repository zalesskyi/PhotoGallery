package com.zalesskyi.photogallery.navigation

import com.stromee.navigation.screen.AppScreen

interface Navigator {

    fun navigate(command: NavigationCommand)
    fun navigate(direction: String, args: Map<*, *>? = null)
    fun navigate(screen: AppScreen)
}