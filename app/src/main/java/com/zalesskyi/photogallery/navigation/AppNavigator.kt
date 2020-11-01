package com.zalesskyi.photogallery.navigation

import com.zalesskyi.photogallery.android.system.ContextHolder
import com.zalesskyi.photogallery.presentation.main.MainActivity
import javax.inject.Inject

class AppNavigator @Inject constructor(
    private val contextHolder: ContextHolder
) : Navigator {

    override fun navigate(command: NavigationCommand) = Unit

    override fun navigate(direction: NavDirections, args: Map<*, *>?) {
        realNavigation(direction, args)
    }

    private fun realNavigation(direction: NavDirections, args: Map<*, *>?) {
        contextHolder.getContext()?.let { context ->
            val intent = when (direction) {
                NavDirections.SPLASH_TO_MAIN -> MainActivity.getIntent(context)
            }
            context.startActivity(intent)
        }
    }
}