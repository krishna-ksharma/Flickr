package com.wipro.assignment.di

import com.flickr.photos.search.ui.photo.*
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UiModule {
    @ContributesAndroidInjector
    abstract fun bindPhotosActivity(): PhotosActivity

    @ContributesAndroidInjector
    abstract fun bindPhotoDetailActivity(): PhotoDetailActivity

    @ContributesAndroidInjector
    abstract fun bindPhotoSearchActivity(): PhotoSearchActivity

    @ContributesAndroidInjector(modules = [ResourceModule::class, ViewModelModule::class])
    abstract fun bindPhotosFragment(): PhotosFragment

    @ContributesAndroidInjector(modules = [ResourceModule::class, ViewModelModule::class])
    abstract fun bindPhotoDetailFragment(): PhotoDetailFragment

    @ContributesAndroidInjector(modules = [ResourceModule::class, ViewModelModule::class])
    abstract fun bindPhotoSearchFragment(): PhotoSearchFragment
}