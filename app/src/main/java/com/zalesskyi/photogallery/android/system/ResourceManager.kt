package com.zalesskyi.photogallery.android.system

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.zalesskyi.photogallery.android.di.qualifier.AppQualifier
import javax.inject.Inject

class ResourceManager @Inject constructor(@AppQualifier private val context: Context) {

    fun getString(@StringRes id: Int) = context.getString(id)

    fun getString(@StringRes id: Int, vararg formatArgs: Any) =
            String.format(context.getString(id, *formatArgs))

    fun getDrawable(@DrawableRes id: Int) = context.getDrawable(id)
}