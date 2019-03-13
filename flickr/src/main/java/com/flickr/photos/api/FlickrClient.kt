package com.flickr.photos.api

import com.flickr.photos.api.di.ApiModule
import com.flickr.photos.api.di.DaggerApiComponent
import javax.inject.Inject

class FlickrClient {

    @Inject
    lateinit var flickrApi: FlickrApi

    @Inject
    constructor() {
        setupFlickrClient()
    }

    private fun setupFlickrClient() {
        DaggerApiComponent.builder()
            .apiModule(ApiModule("https://api.flickr.com"))
            .build()
            .inject(this)
    }

    companion object {
        @JvmStatic
        var instance = FlickrClient()
    }
}

