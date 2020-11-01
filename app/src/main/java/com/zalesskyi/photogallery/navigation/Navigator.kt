package com.zalesskyi.photogallery.navigation

import androidx.navigation.fragment.FragmentNavigator

interface Navigator {

    fun navigate(command: NavigationCommand,
                 extras: FragmentNavigator.Extras? = null)

    fun navigate(direction: NavDirections, args: Map<*, *>? = null)
}