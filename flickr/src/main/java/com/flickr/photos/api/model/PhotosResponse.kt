package com.flickr.photos.api.model

import com.google.gson.annotations.SerializedName


class PhotosResponse : FlickrResponse() {
    @SerializedName("photos")
    var photos: Photos = Photos()
}