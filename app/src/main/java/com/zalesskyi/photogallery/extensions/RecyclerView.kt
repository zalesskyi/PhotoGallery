package com.zalesskyi.photogallery.extensions

import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.set(listAdapter: RecyclerView.Adapter<*>) = adapter ?: run { adapter = listAdapter }

fun RecyclerView.clear() = run { adapter = null }