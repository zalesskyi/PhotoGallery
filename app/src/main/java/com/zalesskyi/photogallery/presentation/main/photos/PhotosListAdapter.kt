package com.zalesskyi.photogallery.presentation.main.photos

import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.zalesskyi.domain.models.Photo
import com.zalesskyi.photogallery.R
import com.zalesskyi.photogallery.databinding.ItemPhotoBinding
import com.zalesskyi.photogallery.databinding.ItemSkeletonAlbumBinding
import com.zalesskyi.photogallery.extensions.AppSkeletonItem
import com.zalesskyi.photogallery.utils.ITEM_VIEW_TYPE
import com.zalesskyi.photogallery.utils.SKELETON_VIEW_TYPE

class PhotosAdapter(list: List<Parcelable>,
                    private val onItemClick: (Photo) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val data = list.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            when (viewType) {
                SKELETON_VIEW_TYPE -> SkeletonHolder.newInstance(parent)
                else -> PhotoHolder.newInstance(parent, onItemClick)
            }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (data[position] as? Photo)?.let {
            (holder as? PhotoHolder)?.bind(it)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemViewType(position: Int): Int =
            when (data[position]) {
                is AppSkeletonItem -> SKELETON_VIEW_TYPE
                else -> ITEM_VIEW_TYPE
            }

    fun updateAllNotify(list: List<Parcelable>) {
        this.data.clear()
        this.data.addAll(list)
        notifyDataSetChanged()
    }

    class PhotoHolder(private val binding: ItemPhotoBinding,
                      private val onItemClick: (Photo) -> Unit) :
            RecyclerView.ViewHolder(binding.root) {

        companion object {

            fun newInstance(parent: ViewGroup, onItemClick: (Photo) -> Unit) =
                    PhotoHolder(DataBindingUtil.inflate(
                            LayoutInflater.from(parent.context),
                            R.layout.item_photo,
                            parent,
                            false), onItemClick)
        }

        fun bind(photo: Photo) {
            binding.item = photo
            binding.root.setOnClickListener { onItemClick(photo) }
        }
    }

    class SkeletonHolder(binding: ItemSkeletonAlbumBinding) :
            RecyclerView.ViewHolder(binding.root) {

        companion object {

            fun newInstance(parent: ViewGroup) =
                    SkeletonHolder(
                            DataBindingUtil.inflate(
                                    LayoutInflater.from(parent.context),
                                    R.layout.item_skeleton_album,
                                    parent,
                                    false
                            )
                    )
        }
    }
}