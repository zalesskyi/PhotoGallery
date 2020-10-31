package com.zalesskyi.photogallery.android.system

import android.app.Activity
import java.lang.ref.WeakReference

class ContextHolder {

    private var wrContext = WeakReference<Activity>(null)

    fun insertContext(context: Activity) {
        wrContext.clear()
        wrContext = WeakReference(context)
    }

    fun clearContext() {
        wrContext.clear()
    }

    fun getContext(): Activity? = wrContext.get()
}