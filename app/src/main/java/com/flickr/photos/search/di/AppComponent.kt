package com.flickr.photos.api.di

import com.flickr.photos.search.FlickrApplication
import com.flickr.photos.search.di.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, ViewModelModule::class, ResourceModule::class, UiModule::class])
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: FlickrApplication): Builder

        fun build(): AppComponent
    }

    abstract fun inject(app: FlickrApplication)
}