package com.flickr.photos.search.ui.photo

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.flickr.photos.search.R
import dagger.android.AndroidInjection

class PhotosActivity : AppCompatActivity() {
    lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navHostFragment.navController.addOnDestinationChangedListener { _, destination, _ ->
            supportActionBar!!.title = destination.label
            when (destination.id) {
                R.id.photoDetailFragment,
                R.id.photoSearchFragment -> {
                    supportActionBar!!.setDisplayHomeAsUpEnabled(true)
                }
                else -> supportActionBar!!.setDisplayHomeAsUpEnabled(false)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                navHostFragment.navController.popBackStack()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
