package com.flickr.photos.search.api

import com.flickr.photos.api.FlickrClient
import com.flickr.photos.api.model.PhotosResponse
import retrofit2.Callback

class FlickrApi {
    companion object {
        @JvmStatic
        fun loadPhotos(callback: Callback<PhotosResponse>, params: Map<String, String>) {
            val call = FlickrClient.instance.flickrApi.loadPhotos(params)
            call.enqueue(callback)
        }

        @JvmStatic
        fun loadPhotoDetail(callback: Callback<PhotosResponse>, params: Map<String, String>) {
            val call = FlickrClient.instance.flickrApi.loadPhotos(params)
            call.enqueue(callback)
        }
    }
}