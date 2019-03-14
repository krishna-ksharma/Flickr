package com.flickr.photos.search.data

import androidx.paging.PageKeyedDataSource
import com.flickr.photos.api.BuildConfig
import com.flickr.photos.api.model.Photo
import com.flickr.photos.api.model.PhotosResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PageKeyedPhotoDataSource(private val tags: String, private val photosNetworkDataSource: PhotosNetworkDataSource) :
    PageKeyedDataSource<Int, Photo>() {
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Photo>) {
        val config = createPhotoConfiguration(1)
        photosNetworkDataSource.loadPhotos((object : ApiCallback<PhotosResponse>() {
            override fun onSuccess(photosResponse: PhotosResponse) {
                callback.onResult(photosResponse.photos.photo, null, 2)
            }
        }), config.params)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Photo>) {
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Photo>) {
        val config = createPhotoConfiguration(params.key)
        photosNetworkDataSource.loadPhotos((object : ApiCallback<PhotosResponse>() {
            override fun onSuccess(photosResponse: PhotosResponse) {
                callback.onResult(photosResponse.photos.photo, params.key + 1)
            }
        }), config.params)
    }

    private fun createPhotoConfiguration(pageKey: Int): PhotoConfig {
        val params = mutableMapOf<String, String>()
        params["method"] = "flickr.photos.search"
        params["format"] = "json"
        params["nojsoncallback"] = "1"
        params["page"] = pageKey.toString()
        params["per_page"] = "50"
        params["api_key"] = BuildConfig.AAP_KEY
        params["tags"] = tags
        params["extras"] = "tags"
        return PhotoConfig(params)
    }

    data class PhotoConfig(val params: MutableMap<String, String>)

    abstract class ApiCallback<T> : Callback<T> {
        override fun onResponse(call: Call<T>, response: Response<T>) {
            if (response.isSuccessful) {
                val photosResponse = response.body()
                if (photosResponse != null) {
                    onSuccess(photosResponse as PhotosResponse)
                }
            }
        }

        override fun onFailure(call: Call<T>, t: Throwable) {}

        abstract fun onSuccess(photosResponse: PhotosResponse)
    }

}