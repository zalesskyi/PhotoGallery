package com.zalesskyi.photogallery.navigation

import androidx.navigation.NavController

class AppNavComponentsNavigator(
    private val navController: NavController,
    private val finishCurrentRoot: () -> Unit

) : Navigator {

    override fun navigate(command: NavigationCommand) {
        realNavigation(command)
    }

    override fun navigate(direction: NavDirections, args: Map<*, *>?) = Unit

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
}