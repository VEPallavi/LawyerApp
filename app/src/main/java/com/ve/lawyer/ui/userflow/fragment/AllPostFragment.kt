package com.ve.lawyer.ui.userflow.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ve.lawyer.R
import com.ve.lawyer.ui.adapter.AllPostListAdapter
import com.ve.lawyer.ui.adapter.NotificationListAdapter
import com.ve.lawyer.ui.listener.ListItemClickListener
import com.ve.lawyer.ui.userflow.UserHomeActivity
import kotlinx.android.synthetic.main.fragment_all_post.view.*
import kotlinx.android.synthetic.main.fragment_notification.view.*

class AllPostFragment : Fragment(), View.OnClickListener, ListItemClickListener {

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
        mView = inflater.inflate(R.layout.fragment_all_post, container, false)
        setupAllPostList()
        setupClickListener()
        return mView
    }

    private fun setupAllPostList() {
        val mAllPostList = ArrayList<String>()
        val mAllPostListAdapter = AllPostListAdapter(activity!!, mAllPostList, this)
        val mLayoutManager = LinearLayoutManager(activity)
        mView?.rv_allPost?.layoutManager = mLayoutManager
        mView?.rv_allPost?.adapter = mAllPostListAdapter
        mView?.rv_allPost?.hasFixedSize()
    }

    private fun setupClickListener() {
    }

    override fun onClick(v: View?) {
        when (v?.id) {

        }
    }

    override fun onViewClicked(view: View, position: Int) {
        (activity as UserHomeActivity).setDisplayFragment(14)
    }
}