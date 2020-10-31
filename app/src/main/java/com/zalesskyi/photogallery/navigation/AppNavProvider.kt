package com.zalesskyi.photogallery.navigation

import androidx.navigation.NavController

interface AppNavProvider {

    fun getNavController(): NavController

    fun finish()
}