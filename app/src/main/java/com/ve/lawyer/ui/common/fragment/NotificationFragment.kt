package com.ve.lawyer.ui.common.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ve.lawyer.R
import com.ve.lawyer.ui.adapter.NotificationListAdapter
import com.ve.lawyer.ui.userflow.UserHomeActivity
import kotlinx.android.synthetic.main.fragment_notification.view.*

class NotificationFragment: Fragment(), View.OnClickListener {
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
        mView = inflater.inflate(R.layout.fragment_notification, container, false)
        setupToolbar()
        setupNotificationList()
        setupClickListener()
        return mView
    }

    private fun setupToolbar() {
        (activity as UserHomeActivity).setToolbarTitle(activity?.resources?.getString(R.string.notification)!!)
        (activity as UserHomeActivity).setToolbarVisibility(true)
        (activity as UserHomeActivity).setToolbarMenuIconVisibility(false)
        (activity as UserHomeActivity).setToolbarBackIconVisibility(true)
        (activity as UserHomeActivity).setBottomNavigationBarVisibility(true)
    }

    private fun setupNotificationList()
    {
        val mNotificationList = ArrayList<String>()
        val mNotificationListAdapter = NotificationListAdapter(activity!!, mNotificationList)
        val mLayoutManager = LinearLayoutManager(activity)
        mView?.rv_notification?.layoutManager = mLayoutManager
        mView?.rv_notification?.adapter = mNotificationListAdapter
        mView?.rv_notification?.hasFixedSize()
    }

    private fun setupClickListener() {

    }

    override fun onClick(v: View?) {
        when (v?.id) {

        }
    }
}