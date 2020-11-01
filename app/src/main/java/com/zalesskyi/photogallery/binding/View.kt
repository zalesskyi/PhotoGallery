package com.zalesskyi.photogallery.binding

import android.view.View
import androidx.databinding.BindingAdapter
import com.zalesskyi.photogallery.utils.MaterialColorsGenerator

@BindingAdapter("backgroundBy")
fun View.generateBackground(obj: Any) {
    setBackgroundColor(MaterialColorsGenerator(context).generateColor(obj))
}