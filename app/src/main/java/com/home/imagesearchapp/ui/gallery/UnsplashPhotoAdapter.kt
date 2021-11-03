package com.home.imagesearchapp.ui.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.home.imagesearchapp.R
import com.home.imagesearchapp.data.UnsplashPhotoObject
import com.home.imagesearchapp.databinding.RecyclerViewItemUnsplashPhotoBinding

class UnsplashPhotoAdapter :
    PagingDataAdapter<UnsplashPhotoObject, UnsplashPhotoAdapter.PhotoViewHolder>(PHOTO_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = RecyclerViewItemUnsplashPhotoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val currentItem = getItem(position)

        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    class PhotoViewHolder(private val binding: RecyclerViewItemUnsplashPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(photo: UnsplashPhotoObject) {
            binding.apply {
                Glide.with(itemView)
                    .load(photo.urls.regular)
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .error(R.drawable.ic_outline_cancel_24)
                    .into(recyclerViewUnsplashImageView)

                recyclerViewTextViewUserName.text = photo.user.username
            }
        }
    }

    companion object {
        private val PHOTO_COMPARATOR = object : DiffUtil.ItemCallback<UnsplashPhotoObject>() {
            override fun areItemsTheSame(
                oldItem: UnsplashPhotoObject,
                newItem: UnsplashPhotoObject
            ) = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: UnsplashPhotoObject,
                newItem: UnsplashPhotoObject
            ) = oldItem == newItem

        }
    }
}