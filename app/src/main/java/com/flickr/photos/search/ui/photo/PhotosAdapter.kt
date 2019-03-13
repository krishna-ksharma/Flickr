package com.flickr.photos.search.ui.photo

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.flickr.photos.api.model.Photo
import com.flickr.photos.search.R
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import kotlinx.android.synthetic.main.photo_item.view.*

class PhotosAdapter(private val context: Context) :
    PagedListAdapter<Photo, PhotosAdapter.ViewHolder>(DIFF_UTIL_CALLBACK) {

    companion object {
        val DIFF_UTIL_CALLBACK = object : DiffUtil.ItemCallback<Photo>() {
            override fun areContentsTheSame(oldItem: Photo, newItem: Photo) = oldItem == newItem
            override fun areItemsTheSame(oldItem: Photo, newItem: Photo) = oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.photo_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViews(getItem(position))
    }

    inner class ViewHolder : RecyclerView.ViewHolder, View.OnClickListener {
        constructor(itemView: View) : super(itemView) {
            itemView.setOnClickListener(this)
        }

        fun bindViews(photo: Photo?) {
            photo?.let {
                itemView.title.text = it.title
                itemView.description.text = it.tags
                loadThumbImage(it)
            }
        }

        override fun onClick(v: View) {
            val photo = getItem(adapterPosition)!!
            val photoParcelable =
                PhotoParcelable(photo.title, buildPhotoUrl(photo), photo.tags)
            PhotoDetailActivity.launch(v.context, photoParcelable)
        }

        private fun loadThumbImage(photo: Photo) {
            Picasso.with(itemView.context)
                .load(buildThumbUrl(photo))
                .transform(CropCircleTransformation())
                .fit()
                .placeholder(R.drawable.ic_photo)
                .centerCrop()
                .into(itemView.thumbIcon)
        }

        private fun buildThumbUrl(photo: Photo): String {
            val url = itemView.resources.getString(R.string.thumb_url, photo.farm, photo.server, photo.id, photo.secret)
            Log.d("KK", "ThumbUrl $url ")
            return url
        }

        private fun buildPhotoUrl(photo: Photo): String {
            val url = itemView.resources.getString(R.string.photo_url, photo.farm, photo.server, photo.id, photo.secret)
            Log.d("KK", "ThumbUrl $url ")
            return url
        }
    }
}