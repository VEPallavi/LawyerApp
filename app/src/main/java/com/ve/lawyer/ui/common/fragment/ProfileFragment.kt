package com.ve.lawyer.ui.common.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ve.lawyer.R
import com.ve.lawyer.ui.userflow.UserHomeActivity

class ProfileFragment: Fragment(), View.OnClickListener {
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
        mView = inflater.inflate(R.layout.fragment_profile, container, false)
        setupToolbar()
        setupClickListener()
        return mView
    }

    private fun setupToolbar() {
        (activity as UserHomeActivity).setToolbarTitle(activity?.resources?.getString(R.string.profile)!!)
        (activity as UserHomeActivity).setToolbarVisibility(true)
        (activity as UserHomeActivity).setToolbarMenuIconVisibility(true)
        (activity as UserHomeActivity).setToolbarBackIconVisibility(false)
    }

    private fun setupClickListener() {

    }

    override fun onClick(v: View?) {
        when (v?.id) {

        }
    }
}