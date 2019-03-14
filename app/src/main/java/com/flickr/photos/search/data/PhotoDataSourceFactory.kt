package com.flickr.photos.search.data

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.flickr.photos.api.model.Photo

class PhotoDataSourceFactory(private val tags: String, private val photosNetworkDataSource: PhotosNetworkDataSource) :
    DataSource.Factory<Int, Photo>() {
    private val pageKeyedPhotoLiveData: MutableLiveData<PageKeyedPhotoDataSource> = MutableLiveData()
    override fun create(): DataSource<Int, Photo> {
        val dataSource = PageKeyedPhotoDataSource(tags, photosNetworkDataSource)
        pageKeyedPhotoLiveData.postValue(dataSource)
        return dataSource
    }
}