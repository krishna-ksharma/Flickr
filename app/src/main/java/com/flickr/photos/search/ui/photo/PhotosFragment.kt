package com.flickr.photos.search.ui.photo

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.flickr.photos.search.R
import com.flickr.photos.search.di.ViewModelFactory
import com.flickr.photos.search.ui.viewmodel.PhotosViewModel
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_photos.*
import javax.inject.Inject

class PhotosFragment : Fragment() {

    private lateinit var photosViewModel: PhotosViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var photosAdapter: PhotosAdapter
    lateinit var tagKey: String

    private fun setupAdapter() {
        photosAdapter = PhotosAdapter(requireContext())
        photosRecyclerView.setHasFixedSize(true)
        photosRecyclerView.layoutManager = LinearLayoutManager(context)
        photosRecyclerView.adapter = photosAdapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tagKey = arguments!!.getString(SEARCH_KEY)
        photosViewModel = ViewModelProviders.of(this, viewModelFactory).get(PhotosViewModel::class.java)
        onRefresh()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_photos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        searchFab.setOnClickListener {
            PhotoSearchActivity.launch(
                requireContext()
            )
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observePhotos()
        swipeRefresh.setOnRefreshListener {
            swipeRefresh.isRefreshing = false
            onRefresh()
        }
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    private fun observePhotos() {
        photosViewModel.photosResult?.observe(this, Observer { photos ->
            photosAdapter.submitList(photos)
        })
    }

    private fun onRefresh() {
        photosViewModel.loadPhotos(tagKey)
    }

    companion object {
        private const val SEARCH_KEY = "key"
        fun newInstance(tagKey: String): PhotosFragment {
            val fragment = PhotosFragment()
            val bundle = Bundle()
            bundle.putString(SEARCH_KEY, tagKey)
            fragment.arguments = bundle
            return fragment
        }
    }
}