package com.wipro.assignment.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.flickr.photos.search.di.ViewModelFactory
import com.flickr.photos.search.ui.viewmodel.PhotosViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(PhotosViewModel::class)
    abstract fun bindFactsViewModel(photosViewModel: PhotosViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}