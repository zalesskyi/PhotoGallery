package com.stromee.navigation.screen

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment

abstract class AppScreen {

    protected val screenKey = javaClass.canonicalName

    open fun getFragment(): Fragment? {
        return null
    }

    open fun getActivityIntent(context: Context): Intent? {
        return null
    }
}