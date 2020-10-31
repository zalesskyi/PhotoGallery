package com.zalesskyi.photogallery.navigation

import androidx.navigation.NavController
import com.stromee.navigation.screen.AppScreen

class AppNavComponentsNavigator(
    private val navController: NavController,
    private val finishCurrentRoot: () -> Unit

) : Navigator {

    override fun navigate(command: NavigationCommand) {
        realNavigation(command)
    }

    private fun realNavigation(command: NavigationCommand) {
        when (command) {
            is NavigationCommand.Back,
            is NavigationCommand.BackTo,
            is NavigationCommand.ToRoot -> Unit

            is NavigationCommand.To -> {
                if (hasCurrentDestinationDirection(command.directions)) {
                    navController.navigate(command.directions)
                }
            }
            is NavigationCommand.ToDirections -> {
                if (hasCurrentDestinationDirection(command.directions.actionId)) {
                    navController.navigate(command.directions)
                }
            }
            is NavigationCommand.ToNewRoot -> {
                if (hasCurrentDestinationDirection(command.directions)) {
                    navController.navigate(command.directions)
                    finishCurrentRoot()
                }
            }
        }
    }

    private fun hasCurrentDestinationDirection(actionId: Int): Boolean {
        return navController.currentDestination?.getAction(actionId) != null
    }

    override fun navigate(direction: String, args: Map<*, *>?) {
        throw NotImplementedError()
    }

    override fun navigate(screen: AppScreen) {
        throw NotImplementedError()
    }
}