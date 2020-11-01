package com.zalesskyi.photogallery.extensions

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.annotation.DrawableRes
import coil.load

const val imageItemSize = 700

fun ImageView.image(image: String?,
                    @DrawableRes placeHolderResId: Int? = null,
                    placeHolder: Drawable? = null) {
    load(image) {
        placeHolderResId?.let(::placeholder)
        placeHolder?.let(::placeholder)
        size(imageItemSize)
    }
}