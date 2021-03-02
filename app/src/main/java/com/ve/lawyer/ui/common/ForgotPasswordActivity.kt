package com.ve.lawyer.ui.common

import android.os.Bundle
import android.view.View
import com.ve.lawyer.R
import com.ve.lawyer.ui.common.base.BaseActivity
import com.ve.lawyer.ui.listener.EditTextFocusListener
import kotlinx.android.synthetic.main.activity_forgot_password.*

class ForgotPasswordActivity : BaseActivity(), View.OnClickListener {

    private var mUserType: String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        setupUI()
        setupClickListener()
    }

    private fun setupUI()
    {
        et_forgotEmail.onFocusChangeListener =
                EditTextFocusListener(this@ForgotPasswordActivity, et_forgotEmail, iv_forgotEmail, lyt_forgotEmail)
    }

    private fun setupClickListener()
    {
        back.setOnClickListener(this)
        btn_resetPassword.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id)
        {
            R.id.back ->
            {
                onBackPressed()
            }
            R.id.btn_resetPassword ->
            {

            }
        }
    }
}