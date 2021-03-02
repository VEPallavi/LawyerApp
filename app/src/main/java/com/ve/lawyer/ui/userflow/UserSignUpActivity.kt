package com.ve.lawyer.ui.userflow

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import com.ve.lawyer.R
import com.ve.lawyer.ui.common.base.BaseActivity
import com.ve.lawyer.ui.listener.UserSignUpEditTextFocusListener
import kotlinx.android.synthetic.main.activity_user_signup.*

class UserSignUpActivity : BaseActivity(), View.OnClickListener {

    private var isPasswordShow: Boolean = true
    private var isConfirmPasswordShow: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_signup)

        setupUI()
        setupClickListener()
    }

    private fun setupUI()
    {
        et_firstName.onFocusChangeListener =
                UserSignUpEditTextFocusListener(this@UserSignUpActivity, et_firstName, iv_firstName, lyt_firstName)
        et_lastName.onFocusChangeListener =
                UserSignUpEditTextFocusListener(this@UserSignUpActivity, et_lastName, iv_lastName, lyt_lastName)
        et_email.onFocusChangeListener =
                UserSignUpEditTextFocusListener(this@UserSignUpActivity, et_email, iv_email, lyt_email)
        et_password.onFocusChangeListener =
                UserSignUpEditTextFocusListener(this@UserSignUpActivity, et_password, iv_lock, lyt_password)
        et_confirmPass.onFocusChangeListener =
                UserSignUpEditTextFocusListener(this@UserSignUpActivity, et_confirmPass, iv_lockConfirmPass, lyt_confirmPass)
    }

    private fun setupClickListener()
    {
        back.setOnClickListener(this)
        btn_signUp.setOnClickListener(this)
        iv_showHidePass.setOnClickListener(this)
        iv_showHideConfirmPass.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id)
        {
            R.id.back ->
            {
                onBackPressed()
            }
            R.id.btn_signUp ->
            {

            }
            R.id.iv_showHidePass ->
            {
                showHidePassword()
            }
            R.id.iv_showHideConfirmPass ->
            {
                showHideConfirmPassword()
            }
        }
    }

    private fun showHidePassword() {
        if (isPasswordShow) {
            isPasswordShow = false
            iv_showHidePass.setImageResource(R.mipmap.eye_on_icon)
            et_password.transformationMethod = HideReturnsTransformationMethod.getInstance()
        } else {
            isPasswordShow = true
            iv_showHidePass.setImageResource(R.mipmap.eye_off_icon)
            et_password.transformationMethod = PasswordTransformationMethod.getInstance()
        }
    }

    private fun showHideConfirmPassword() {
        if (isConfirmPasswordShow) {
            isConfirmPasswordShow = false
            iv_showHideConfirmPass.setImageResource(R.mipmap.eye_on_icon)
            et_confirmPass.transformationMethod = HideReturnsTransformationMethod.getInstance()
        } else {
            isConfirmPasswordShow = true
            iv_showHideConfirmPass.setImageResource(R.mipmap.eye_off_icon)
            et_confirmPass.transformationMethod = PasswordTransformationMethod.getInstance()
        }
    }
}