package com.wipro.assignment.di

import android.content.Context
import com.flickr.photos.search.FlickrApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    internal fun provideContext(application: FlickrApplication): Context {
        return application.applicationContext
    }
}