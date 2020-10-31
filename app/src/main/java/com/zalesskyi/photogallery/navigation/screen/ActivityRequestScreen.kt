package com.stromee.navigation.screen

import androidx.fragment.app.Fragment


abstract class ActivityRequestScreen(val requestCode: Int) : AppScreen() {

    override fun getFragment(): Fragment? {
        return super.getFragment()
    }
}