package com.zalesskyi.photogallery.utils

import android.content.Context
import androidx.annotation.ColorInt
import com.zalesskyi.photogallery.R

/**
 * Util, that help us get
 * random material color by any value.
 */
class MaterialColorsGenerator(context: Context) {

    private val materialColors =
        context.resources.getIntArray(R.array.materials_colors)

    /**
     * Generate random material color by [obj].
     *
     * @param obj color will be generated based on this value
     * @return value of generated color
     */
    @ColorInt
    fun generateColor(obj: Any) = materialColors[obj.hashCode() % materialColors.size]
}