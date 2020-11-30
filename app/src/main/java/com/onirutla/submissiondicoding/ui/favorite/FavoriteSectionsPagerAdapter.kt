package com.onirutla.submissiondicoding.ui.favorite

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.onirutla.submissiondicoding.R
import com.onirutla.submissiondicoding.ui.favorite.movie.FavoriteMovieFragment
import com.onirutla.submissiondicoding.ui.favorite.tv.FavoriteTvFragment

class FavoriteSectionsPagerAdapter (private val mContext: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val title = intArrayOf(R.string.header_movies, R.string.header_tv_show)
    }

    override fun getCount(): Int = title.size

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> FavoriteMovieFragment()
            1 -> FavoriteTvFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence =
        mContext.resources.getString(title[position])
}