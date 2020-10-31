package com.zalesskyi.photogallery.navigation

import com.stromee.navigation.screen.ActivityRequestScreen
import com.stromee.navigation.screen.AppScreen
import com.zalesskyi.photogallery.android.system.ContextHolder
import javax.inject.Inject

class AppNavigator @Inject constructor(
    private val contextHolder: ContextHolder
) : Navigator {

    override fun navigate(command: NavigationCommand) = Unit

    override fun navigate(screen: AppScreen) {
        realNavigation(screen)
    }

    private fun realNavigation(screen: AppScreen) {
        when (screen) {
            is ActivityRequestScreen -> {
                contextHolder.getContext()?.run {
                    startActivityForResult(
                        screen.getActivityIntent(this), screen.requestCode
                    )
                }
            }
            else -> Unit
        }
    }

    override fun navigate(direction: String, args: Map<*, *>?) {
        realNavigation(direction, args)
    }

    private fun realNavigation(direction: String, args: Map<*, *>?) {
        contextHolder.getContext()?.let { context ->
            /*val intent = when (direction) {

                else -> throw NotImplementedError()
            }
            context.startActivity(intent)*/
        }
    }
}