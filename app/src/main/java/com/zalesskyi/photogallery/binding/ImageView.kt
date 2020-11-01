package com.zalesskyi.photogallery.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.zalesskyi.photogallery.extensions.image

@BindingAdapter("image")
fun showImage(view: ImageView, image: String?) {
    view.image(image)
}