package com.flickr.photos.search.ui.photo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.flickr.photos.search.R
import kotlinx.android.synthetic.main.fragment_photo_search.*

class PhotoSearchFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_photo_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchButton.setOnClickListener {
            activity?.finish()
            PhotosActivity.launch(
                requireContext(),
                editSearch.text.toString()
            )
        }
    }

    companion object {
        fun newInstance(): PhotoSearchFragment {
            return PhotoSearchFragment()
        }
    }
}