package com.zalesskyi.photogallery.extensions

import android.view.View
import androidx.core.content.ContextCompat

fun View.gone() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.visible(visible: Boolean, isGone: Boolean = true) {
    this.visibility = if (visible) View.VISIBLE else View.GONE.takeIf { isGone } ?: View.INVISIBLE
}

fun View.setBackgroundColorRes(colorRes: Int) {
    setBackgroundColor(ContextCompat.getColor(context, colorRes))
}