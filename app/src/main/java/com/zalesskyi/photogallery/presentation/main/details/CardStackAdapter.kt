package com.zalesskyi.photogallery.presentation.main.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.zalesskyi.domain.models.Photo
import com.zalesskyi.photogallery.R
import com.zalesskyi.photogallery.databinding.ItemDetailPhotoBinding

class CardStackAdapter(list: List<Photo>) : RecyclerView.Adapter<CardStackAdapter.PhotoHolder>() {

    private val data = list.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder =
        PhotoHolder.newInstance(parent)

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun updateAllNotify(list: List<Photo>) {
        this.data.clear()
        this.data.addAll(list)
        notifyDataSetChanged()
    }

    class PhotoHolder(private val binding: ItemDetailPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {

            fun newInstance(parent: ViewGroup) =
                PhotoHolder(
                    DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_detail_photo,
                    parent,
                    false))
        }

        fun bind(album: Photo) {
            binding.item = album
        }
    }
}