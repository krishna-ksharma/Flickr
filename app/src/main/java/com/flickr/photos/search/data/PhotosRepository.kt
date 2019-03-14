package com.flickr.photos.search.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.flickr.photos.api.model.Photo

class PhotosRepository(private val photosNetworkDataSource: PhotosNetworkDataSource) {

    fun loadPhotos(tags: String): LiveData<PagedList<Photo>> {
        return LivePagedListBuilder(PhotoDataSourceFactory(tags, photosNetworkDataSource), PAGED_PHOTO_LIST_CONFIG)
            .build()
    }

    companion object {
        private val PAGED_PHOTO_LIST_CONFIG = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(20)
            .setPageSize(50)
            .setPrefetchDistance(20)
            .build()
    }
}