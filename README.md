# Flickr Photo Viewer
This application loads the photos and details (you search) from Flickr image hosting service.Each photo has following meta information

  - Title of the Photo
  - Tags on the Photo
  - Thumb image of the Photo
  
 ![Alt text](/screenshots/photo-list.jpg?raw=true "Photos") ![Alt text](/screenshots/photo-search.jpg?raw=true "Search") ![Alt text](/screenshots/photo-detail.jpg?raw=true "Phot Detail")
 
 
# Tech Stack
This application is written in Kotlin, have tried to separate the modules as much as possible. For network communication have created separate module called flickr which has set of api to load the photos from network. The idea was to have keep the api related stuff in separate module so that can be used in any other application as well. Think of this module provides set of Facebook API's and have OneToMany client application who can simply use this module to get the facebook api's such as login, friends, messages, photos etc.  

To build this application have used following libraries/pattern
- [Picasso](https://square.github.io/picasso/)
- [Retrofit](https://square.github.io/retrofit/)
- [Dagger](https://google.github.io/dagger/android.html)
- [Android architecture components](https://developer.android.com/topic/libraries/architecture)
