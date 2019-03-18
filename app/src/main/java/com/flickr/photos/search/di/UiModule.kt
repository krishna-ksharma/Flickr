package com.flickr.photos.search.di

import com.flickr.photos.search.ui.photo.PhotoDetailFragment
import com.flickr.photos.search.ui.photo.PhotoSearchFragment
import com.flickr.photos.search.ui.photo.PhotosActivity
import com.flickr.photos.search.ui.photo.PhotosFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UiModule {
    @ContributesAndroidInjector
    abstract fun bindPhotosActivity(): PhotosActivity

    @ContributesAndroidInjector(modules = [ResourceModule::class, ViewModelModule::class])
    abstract fun bindPhotosFragment(): PhotosFragment

    @ContributesAndroidInjector(modules = [ResourceModule::class, ViewModelModule::class])
    abstract fun bindPhotoDetailFragment(): PhotoDetailFragment

    @ContributesAndroidInjector(modules = [ResourceModule::class, ViewModelModule::class])
    abstract fun bindPhotoSearchFragment(): PhotoSearchFragment
}