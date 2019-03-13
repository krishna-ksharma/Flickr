package com.flickr.photos.search.data

import com.flickr.photos.api.model.PhotosResponse
import com.flickr.photos.search.api.FlickrApi
import retrofit2.Callback

class PhotosNetworkDataSource {
    fun loadPhotos(callback: Callback<PhotosResponse>, params : Map<String, String>) {
        FlickrApi.loadPhotos(callback, params)
    }
}