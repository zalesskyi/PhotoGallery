package com.zalesskyi.photogallery.android.system.lifecycle

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import javax.inject.Inject

class LifecycleProvider @Inject constructor() : Lifecycle, LifecycleObserver {

    private var isApplicationAvailable = false

    override fun isApplicationAvailable() = isApplicationAvailable

    @OnLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_START)
    fun onStartApplication() {
        isApplicationAvailable = true
    }

    @OnLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_STOP)
    fun onStopApplication() {
        isApplicationAvailable = false
    }
}