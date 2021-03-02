package com.ve.lawyer.ui.common.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ve.lawyer.R
import com.ve.lawyer.ui.adapter.DashboardListAdapter
import com.ve.lawyer.ui.listener.ListItemClickListener
import com.ve.lawyer.ui.userflow.UserHomeActivity
import kotlinx.android.synthetic.main.fragment_categories.view.*
import kotlinx.android.synthetic.main.fragment_dashboard.view.*
import kotlinx.android.synthetic.main.fragment_dashboard.view.btn_seeAll

class DashboardFragment: Fragment(), View.OnClickListener, ListItemClickListener {
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
        mView = inflater.inflate(R.layout.fragment_dashboard, container, false)
        setupToolbar()
        setupDashboardList()
        setupClickListener()
        return mView
    }

    private fun setupToolbar() {
        (activity as UserHomeActivity).setToolbarTitle(activity?.resources?.getString(R.string.dashboard)!!)
        (activity as UserHomeActivity).setToolbarVisibility(true)
        (activity as UserHomeActivity).setToolbarMenuIconVisibility(true)
        (activity as UserHomeActivity).setToolbarBackIconVisibility(false)
    }

    private fun setupDashboardList()
    {
        val mDashboardList = ArrayList<String>()
        val mDashboardListAdapter = DashboardListAdapter(activity!!, mDashboardList, this)
        val mLayoutManager = LinearLayoutManager(activity)
        mView?.rv_dashboard?.layoutManager = mLayoutManager
        mView?.rv_dashboard?.adapter = mDashboardListAdapter
        mView?.rv_dashboard?.hasFixedSize()
    }

    private fun setupClickListener() {
        //mView?.btn_seeAll?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {

        }
    }

    override fun onViewClicked(view: View, position: Int) {
        (activity as UserHomeActivity).setDisplayFragment(13)
    }
}