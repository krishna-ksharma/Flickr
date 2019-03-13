package com.flickr.photos.search.ui.photo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.flickr.photos.search.R
import dagger.android.AndroidInjection

class PhotoDetailActivity : AppCompatActivity() {
    private lateinit var photoParcelable: PhotoParcelable
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        photoParcelable = intent.getParcelableExtra(META_INFO)
        title = getString(R.string.photo)
        addPhotosFragment()
    }

    companion object {
        private const val META_INFO = "photoMetaData"
        fun launch(context: Context, parcelable: PhotoParcelable) {
            val bundle = Bundle()
            bundle.putParcelable(META_INFO, parcelable)
            val intent = Intent(context, PhotoDetailActivity::class.java)
            intent.putExtras(bundle)
            context.startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    private fun addPhotosFragment() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragment = PhotoDetailFragment.newInstance(photoParcelable)
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }
}