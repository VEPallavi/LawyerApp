package com.ve.lawyer.ui.userflow.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ve.lawyer.R
import com.ve.lawyer.ui.adapter.PostTabViewPagerAdapter
import com.ve.lawyer.ui.userflow.UserHomeActivity
import com.ve.lawyer.utils.AppConstants
import kotlinx.android.synthetic.main.fragment_user_post.view.*

class UserPostsFragment: Fragment(), View.OnClickListener {

    private var mView: View? = null
    private var comingFrom: String = ""

    companion object {
        fun newInstance(comingType: String?): UserPostsFragment {
            val f = UserPostsFragment()

            // Supply num input as an argument.
            val args = Bundle()
            args.putSerializable(AppConstants.USER_POST_PAGE_SHOWING_FROM, comingType)
            f.setArguments(args)
            return f
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        mView = inflater.inflate(R.layout.fragment_user_post, container, false)
        setupToolbar()
        setupViews()
        setupClickListener()
        return mView
    }

    private fun setupToolbar() {
        (activity as UserHomeActivity).setToolbarTitle(activity?.resources?.getString(R.string.post)!!)
        (activity as UserHomeActivity).setToolbarVisibility(true)
        (activity as UserHomeActivity).setToolbarMenuIconVisibility(false)
        (activity as UserHomeActivity).setToolbarBackIconVisibility(true)
    }

    private fun setupViews() {

        mView?.tabLayout?.addTab(mView?.tabLayout?.newTab()!!.setText("All Post"))
        mView?.tabLayout?.addTab(mView?.tabLayout?.newTab()!!.setText("My Post"))

        val adapter = PostTabViewPagerAdapter(childFragmentManager, 2)
        mView?.viewPager?.adapter = adapter

        mView?.tabLayout?.setupWithViewPager(mView?.viewPager)
    }

    private fun setupClickListener() {
    }

    override fun onClick(v: View?) {
        when (v?.id) {

        }
    }
}