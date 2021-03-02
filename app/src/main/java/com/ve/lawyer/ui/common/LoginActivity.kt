package com.ve.lawyer.ui.common

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.text.style.ForegroundColorSpan
import android.view.View
import com.ve.lawyer.R
import com.ve.lawyer.ui.common.base.BaseActivity
import com.ve.lawyer.ui.listener.EditTextFocusListener
import com.ve.lawyer.ui.userflow.UserHomeActivity
import com.ve.lawyer.utils.SlideAnimationUtil
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(), View.OnClickListener {

    private var isPasswordShow: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setupUI()
        setupClickListener()
    }

    private fun setupUI()
    {
        val spannable1 = SpannableString("Welcome To ")
        spannable1.setSpan(
                ForegroundColorSpan(Color.parseColor("#a1a1a1")),
                0,
                "Welcome To ".length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        tv_welcomeMsg.text = spannable1
        val spannable2 = SpannableString("Law Room")
        spannable2.setSpan(
                ForegroundColorSpan(Color.parseColor("#000000")),
                0,
                "Law Room".length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        tv_welcomeMsg.append(spannable2)

        et_loginEmail.onFocusChangeListener =
                EditTextFocusListener(this@LoginActivity, et_loginEmail, iv_email, lyt_email)
        et_loginPassword.onFocusChangeListener =
                EditTextFocusListener(this@LoginActivity, et_loginPassword, iv_lock, lyt_password)
    }

    private fun setupClickListener()
    {
        back.setOnClickListener(this)
        tv_forgotPassword.setOnClickListener(this)
        btn_signIn.setOnClickListener(this)
        iv_showHidePass.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id)
        {
            R.id.back ->
            {
                onBackPressed()
            }
            R.id.btn_signIn ->
            {
                moveToHomeScreen()
            }
            R.id.tv_forgotPassword ->
            {
                moveToForgotPasswordScreen()
            }
            R.id.iv_showHidePass ->
            {
                showHidePassword()
            }
        }
    }

    private fun showHidePassword() {
        if (isPasswordShow) {
            isPasswordShow = false
            iv_showHidePass.setImageResource(R.mipmap.eye_on_icon)
            et_loginPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
        } else {
            isPasswordShow = true
            iv_showHidePass.setImageResource(R.mipmap.eye_off_icon)
            et_loginPassword.transformationMethod = PasswordTransformationMethod.getInstance()
        }
    }

    private fun moveToForgotPasswordScreen()
    {
        val intent = Intent(this@LoginActivity, ForgotPasswordActivity::class.java)
        startActivity(intent)
        finish()
        SlideAnimationUtil.slideNextAnimation(this@LoginActivity)
    }

    private fun moveToHomeScreen()
    {
        val intent = Intent(this@LoginActivity, UserHomeActivity::class.java)
        startActivity(intent)
        finish()
        SlideAnimationUtil.slideNextAnimation(this@LoginActivity)
    }
}