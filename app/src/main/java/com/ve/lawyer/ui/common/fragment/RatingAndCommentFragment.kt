package com.ve.lawyer.ui.common.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ve.lawyer.R
import com.ve.lawyer.ui.adapter.NotificationListAdapter
import com.ve.lawyer.ui.adapter.RatingAndCommentListAdapter
import com.ve.lawyer.ui.userflow.UserHomeActivity
import kotlinx.android.synthetic.main.fragment_rating_and_comment.view.*

class RatingAndCommentFragment: Fragment(), View.OnClickListener {
    private var mView: View? = null

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
        mView = inflater.inflate(R.layout.fragment_rating_and_comment, container, false)
        setupToolbar()
        setupRatingAndCommentList()
        setupClickListener()
        return mView
    }

    private fun setupToolbar() {
        (activity as UserHomeActivity).setToolbarTitle(activity?.resources?.getString(R.string.rating_comment)!!)
        (activity as UserHomeActivity).setToolbarVisibility(true)
        (activity as UserHomeActivity).setToolbarMenuIconVisibility(false)
        (activity as UserHomeActivity).setToolbarBackIconVisibility(true)
        (activity as UserHomeActivity).setBottomNavigationBarVisibility(false)
    }

    private fun setupRatingAndCommentList()
    {
        val mRatingAndCommentList = ArrayList<String>()
        val mRatingAndCommentListAdapter = RatingAndCommentListAdapter(activity!!, mRatingAndCommentList)
        val mLayoutManager = LinearLayoutManager(activity)
        mView?.rv_ratingAndComment?.layoutManager = mLayoutManager
        mView?.rv_ratingAndComment?.adapter = mRatingAndCommentListAdapter
        mView?.rv_ratingAndComment?.hasFixedSize()
    }

    private fun setupClickListener() {

    }

    override fun onClick(v: View?) {
        when (v?.id) {

        }
    }
}