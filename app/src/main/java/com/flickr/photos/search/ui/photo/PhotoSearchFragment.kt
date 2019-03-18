package com.flickr.photos.search.ui.photo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.flickr.photos.search.R
import com.flickr.photos.search.hideKeyboard
import kotlinx.android.synthetic.main.fragment_photo_search.*

class PhotoSearchFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_photo_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchButton.setOnClickListener {
            searchButton.hideKeyboard()
            navigateToMainScreen()
        }
    }

    private fun navigateToMainScreen() {
        val bundle = Bundle()
        bundle.putString(PhotosFragment.SEARCH_KEY, editSearch.text.toString().trim())
        val navController = Navigation.findNavController(requireActivity(), R.id.fragment_container)
        navController.popBackStack(R.id.photosFragment, true)
        navController.navigate(R.id.photosFragment, bundle)
    }
}