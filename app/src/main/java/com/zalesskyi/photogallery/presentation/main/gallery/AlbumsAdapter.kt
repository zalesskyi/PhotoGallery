package com.zalesskyi.photogallery.presentation.main.gallery

import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.zalesskyi.domain.models.Album
import com.zalesskyi.photogallery.R
import com.zalesskyi.photogallery.databinding.ItemAlbumBinding
import com.zalesskyi.photogallery.databinding.ItemSkeletonAlbumBinding
import com.zalesskyi.photogallery.extensions.AppSkeletonItem
import com.zalesskyi.photogallery.utils.ITEM_VIEW_TYPE
import com.zalesskyi.photogallery.utils.SKELETON_VIEW_TYPE

class AlbumsAdapter(list: List<Parcelable>,
                    private val onItemClick: (Int) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val data = list.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            when (viewType) {
                SKELETON_VIEW_TYPE -> SkeletonHolder.newInstance(parent)
                else -> AlbumHolder.newInstance(parent, onItemClick)
            }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (data[position] as? Album)?.let {
            (holder as? AlbumHolder)?.bind(it)
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

    class AlbumHolder(private val binding: ItemAlbumBinding,
                      private val itemClick: ((Int) -> Unit)?) :
            RecyclerView.ViewHolder(binding.root) {

        companion object {

            fun newInstance(parent: ViewGroup,
                            itemClick: ((Int) -> Unit)?) =
                    AlbumHolder(DataBindingUtil.inflate(
                            LayoutInflater.from(parent.context),
                            R.layout.item_album,
                            parent,
                            false), itemClick)
        }

        fun bind(album: Album) {
            binding.item = album
            binding.root.setOnClickListener { itemClick?.invoke(album.id) }
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