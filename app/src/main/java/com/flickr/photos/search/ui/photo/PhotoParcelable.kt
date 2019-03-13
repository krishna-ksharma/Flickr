package com.flickr.photos.search.ui.photo

import android.os.Parcel
import android.os.Parcelable

data class PhotoParcelable(val title: String?, val photoUrl: String?, val tags: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(photoUrl)
        parcel.writeString(tags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PhotoParcelable> {
        override fun createFromParcel(parcel: Parcel): PhotoParcelable {
            return PhotoParcelable(parcel)
        }

        override fun newArray(size: Int): Array<PhotoParcelable?> {
            return arrayOfNulls(size)
        }
    }
}