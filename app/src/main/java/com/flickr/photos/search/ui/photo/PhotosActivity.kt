package com.flickr.photos.search.ui.photo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.flickr.photos.search.R
import dagger.android.AndroidInjection

class PhotosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        if (savedInstanceState == null) {
            addPhotosFragment("BMW")
        }
    }

    private fun addPhotosFragment(tagKey: String) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragment = PhotosFragment.newInstance(tagKey)
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }

    companion object {
        private const val TAG = "SearchKey"
        fun launch(context: Context, tagKey: String) {
            val bundle = Bundle()
            bundle.putString(TAG, tagKey)
            val intent = Intent(context, PhotosActivity::class.java)
            intent.putExtras(bundle)
            context.startActivity(intent)
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        addPhotosFragment(intent.extras.getString(TAG))
    }
}
