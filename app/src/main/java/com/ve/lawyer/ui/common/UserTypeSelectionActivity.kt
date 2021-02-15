package com.ve.lawyer.ui.common

import android.os.Bundle
import android.view.View
import com.ve.lawyer.R
import com.ve.lawyer.ui.common.base.BaseActivity

class UserTypeSelectionActivity : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_type)

        setupUI()
        setupClickListener()
    }

    private fun setupUI()
    {

    }

    private fun setupClickListener()
    {

    }

    override fun onClick(p0: View?) {
    }
}