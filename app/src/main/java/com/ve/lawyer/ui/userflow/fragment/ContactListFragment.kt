package com.ve.lawyer.ui.userflow.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ve.lawyer.R
import com.ve.lawyer.ui.adapter.ContactListAdapter
import com.ve.lawyer.ui.listener.ListItemClickListener
import com.ve.lawyer.ui.userflow.UserHomeActivity
import kotlinx.android.synthetic.main.fragment_contact_list.view.*

class ContactListFragment: Fragment(), View.OnClickListener, ListItemClickListener {

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
        mView = inflater.inflate(R.layout.fragment_contact_list, container, false)
        setupToolbar()
        setupContactList()
        setupClickListener()
        return mView
    }

    private fun setupToolbar() {
        (activity as UserHomeActivity).setToolbarTitle(activity?.resources?.getString(R.string.contact_list)!!)
        (activity as UserHomeActivity).setToolbarVisibility(true)
        (activity as UserHomeActivity).setToolbarMenuIconVisibility(false)
        (activity as UserHomeActivity).setToolbarBackIconVisibility(true)
        (activity as UserHomeActivity).setBottomNavigationBarVisibility(false)
    }

    private fun setupContactList()
    {
        val mContactList = ArrayList<String>()
        val mContactListAdapter = ContactListAdapter(activity!!, mContactList, this)
        val mLayoutManager = LinearLayoutManager(activity)
        mView?.rv_contactList?.layoutManager = mLayoutManager
        mView?.rv_contactList?.adapter = mContactListAdapter
        mView?.rv_contactList?.hasFixedSize()
    }

    private fun setupClickListener() {
    }

    override fun onClick(v: View?) {
        when (v?.id) {

        }
    }

    override fun onViewClicked(view: View, position: Int) {
        (activity as UserHomeActivity).setDisplayFragment(2)
    }
}