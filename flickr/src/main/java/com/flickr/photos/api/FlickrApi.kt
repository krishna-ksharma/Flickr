package com.flickr.photos.api

import com.flickr.photos.api.model.PhotosResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface FlickrApi {
    @GET("/services/rest")
    fun loadPhotos(@QueryMap params: Map<String, String>): Call<PhotosResponse>
}