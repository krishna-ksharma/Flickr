package com.wipro.assignment.di

import com.flickr.photos.search.data.PhotosNetworkDataSource
import com.flickr.photos.search.data.PhotosRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ResourceModule {
    @Provides
    @Singleton
    fun providePhotosNetworkDataSource(): PhotosNetworkDataSource {
        return PhotosNetworkDataSource()
    }

    @Provides
    @Singleton
    fun providesPhotosRepository(photosNetworkDataSource: PhotosNetworkDataSource): PhotosRepository {
        return PhotosRepository(photosNetworkDataSource)
    }
}