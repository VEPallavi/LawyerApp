package com.ve.lawyer.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ve.lawyer.ui.userflow.fragment.AllPostFragment
import com.ve.lawyer.ui.userflow.fragment.MyPostFragment

class PostTabViewPagerAdapter(fm: FragmentManager, totalTabs: Int) : FragmentPagerAdapter(fm) {

    private var TOTAL_TAB_COUNT: Int = 0
    init {
        this.TOTAL_TAB_COUNT = totalTabs
    }
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = AllPostFragment()
            1 -> fragment = MyPostFragment()
        }
        return fragment!!
    }

    override fun getCount(): Int {
        return TOTAL_TAB_COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "All Post"
            else -> {
                return "My Post"
            }
        }
        //return "Tab " + (position + 1)
    }
}