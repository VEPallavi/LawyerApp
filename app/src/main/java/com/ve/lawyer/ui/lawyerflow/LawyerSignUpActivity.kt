package com.ve.lawyer.ui.lawyerflow

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import com.ve.lawyer.R
import com.ve.lawyer.ui.common.base.BaseActivity
import com.ve.lawyer.ui.listener.LawyerSignUpEditTextFocusListener
import kotlinx.android.synthetic.main.activity_lawyer_signup.*

class LawyerSignUpActivity : BaseActivity(), View.OnClickListener {

    private var isPasswordShow: Boolean = true
    private var isConfirmPasswordShow: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lawyer_signup)

        setupUI()
        setupClickListener()
    }

    private fun setupUI()
    {
        et_firstName.onFocusChangeListener =
                LawyerSignUpEditTextFocusListener(this@LawyerSignUpActivity, et_firstName, iv_firstName, lyt_firstName)
        et_lastName.onFocusChangeListener =
                LawyerSignUpEditTextFocusListener(this@LawyerSignUpActivity, et_lastName, iv_lastName, lyt_lastName)
        et_email.onFocusChangeListener =
                LawyerSignUpEditTextFocusListener(this@LawyerSignUpActivity, et_email, iv_email, lyt_email)
        et_lawPractice.onFocusChangeListener =
                LawyerSignUpEditTextFocusListener(this@LawyerSignUpActivity, et_lawPractice, iv_lawPractice, lyt_lawPractice)
        et_barNumber.onFocusChangeListener =
                LawyerSignUpEditTextFocusListener(this@LawyerSignUpActivity, et_barNumber, iv_barNumber, lyt_barNumber)
        et_lawFirm.onFocusChangeListener =
                LawyerSignUpEditTextFocusListener(this@LawyerSignUpActivity, et_lawFirm, iv_lawFirm, lyt_lawFirm)
        et_password.onFocusChangeListener =
                LawyerSignUpEditTextFocusListener(this@LawyerSignUpActivity, et_password, iv_lock, lyt_password)
        et_confirmPass.onFocusChangeListener =
                LawyerSignUpEditTextFocusListener(this@LawyerSignUpActivity, et_confirmPass, iv_lockConfirmPass, lyt_confirmPass)
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