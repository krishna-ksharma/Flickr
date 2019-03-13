package com.flickr.photos.search.ui.photo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.flickr.photos.search.R
import dagger.android.AndroidInjection

class PhotoSearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = getString(R.string.photo)
        addPhotosFragment()
    }

    companion object {
        fun launch(context: Context) {
            val intent = Intent(context, PhotoSearchActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    private fun addPhotosFragment() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragment = PhotoSearchFragment.newInstance()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }
}