package com.flickr.photos.api.model

import com.google.gson.annotations.SerializedName


class Photo {
    @SerializedName("id")
    var id: String? = null
    @SerializedName("secret")
    var secret: String? = null
    @SerializedName("server")
    var server: String? = null
    @SerializedName("farm")
    var farm: Int? = null
    @SerializedName("title")
    var title: String? = null
    @SerializedName("tags")
    var tags: String? = null
}