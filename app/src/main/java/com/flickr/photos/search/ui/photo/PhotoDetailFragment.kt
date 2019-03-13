package com.flickr.photos.search.ui.photo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.flickr.photos.search.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_photo_detail.*

class PhotoDetailFragment : Fragment() {
    private lateinit var photoParcelable: PhotoParcelable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        photoParcelable = arguments!!.getParcelable(META_INFO)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_photo_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        photoTitle.text = photoParcelable.title
        photoTags.text = photoParcelable.tags
        loadPhoto()
    }

    private fun loadPhoto() {
        Picasso.with(requireContext())
            .load(photoParcelable.photoUrl)
            .fit()
            .placeholder(R.drawable.camera)
            .centerCrop()
            .into(photoImage)
    }

    companion object {
        private const val META_INFO = "photoMetaData"
        fun newInstance(parcelable: PhotoParcelable): PhotoDetailFragment {
            val fragment = PhotoDetailFragment()
            val bundle = Bundle()
            bundle.putParcelable(META_INFO, parcelable)
            fragment.arguments = bundle
            return fragment
        }
    }
}