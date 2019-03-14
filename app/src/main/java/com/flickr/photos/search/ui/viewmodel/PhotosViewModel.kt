package com.flickr.photos.search.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.flickr.photos.api.model.Photo
import com.flickr.photos.search.data.PhotosRepository
import javax.inject.Inject

class PhotosViewModel @Inject constructor(private val repository: PhotosRepository) : ViewModel() {
    var photosResult: LiveData<PagedList<Photo>>? = null
    fun loadPhotos(tags: String) {
        if (photosResult == null) {
            photosResult = repository.loadPhotos(tags)
        }
    }
}