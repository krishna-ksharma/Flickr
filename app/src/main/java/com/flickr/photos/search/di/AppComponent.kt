package com.flickr.photos.search.di

import com.flickr.photos.search.FlickrApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, ViewModelModule::class, ResourceModule::class, UiModule::class])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: FlickrApplication): Builder

        fun build(): AppComponent
    }

    fun inject(app: FlickrApplication)
}