package com.zalesskyi.photogallery.extensions

import android.os.Parcelable
import com.github.nitrico.lastadapter.StableId
import com.zalesskyi.photogallery.utils.DEFAULT_SKELETON_LIST_SIZE
import com.zalesskyi.photogallery.utils.EMPTY_STRING
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize

fun List<Parcelable>.skeleton(range: Int = DEFAULT_SKELETON_LIST_SIZE) = toMutableList().apply {
    IntRange(0, range.dec()).map { AppSkeletonItem() }.toList<Parcelable>().let {
        clear()
        addAll(it)
    }
}

@Parcelize
data class AppSkeletonItem(val id: String = EMPTY_STRING): Parcelable, StableId {
    @IgnoredOnParcel
    override val stableId = id.hashCode().toLong()
}