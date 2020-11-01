package com.zalesskyi.photogallery.navigation

interface Navigator {

    fun navigate(command: NavigationCommand)
    fun navigate(direction: NavDirections, args: Map<*, *>? = null)
}