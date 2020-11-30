package com.onirutla.submissiondicoding.ui.favorite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.onirutla.submissiondicoding.R
import kotlinx.android.synthetic.main.activity_favorite.*


class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        val sectionsPagerAdapter = FavoriteSectionsPagerAdapter(this, supportFragmentManager)
        favorite_view_pager.adapter = sectionsPagerAdapter
        favorite_tabs.setupWithViewPager(favorite_view_pager)
        supportActionBar?.elevation = 0f
    }
}