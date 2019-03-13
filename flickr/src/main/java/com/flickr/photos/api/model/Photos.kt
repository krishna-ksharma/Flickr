package com.flickr.photos.api.model

import com.google.gson.annotations.SerializedName
import java.util.*

class Photos {
    @SerializedName("page")
    var page: Int = 0
    @SerializedName("pages")
    var pages: Int = 0
    @SerializedName("perpage")
    var perPage: Int = 2
    @SerializedName("total")
    var total: String? = null
    @SerializedName("photo")
    val photo: List<Photo> = ArrayList()
}