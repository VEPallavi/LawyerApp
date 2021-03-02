package com.ve.lawyer.ui.common.fragment

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ve.lawyer.R
import com.ve.lawyer.ui.listener.ChangePasswordEditTextFocusListener
import com.ve.lawyer.ui.userflow.UserHomeActivity
import kotlinx.android.synthetic.main.fragment_change_password.view.*

class ChangePasswordFragment : Fragment(), View.OnClickListener {

    private var isOldPasswordShow: Boolean = true
    private var isNewPasswordShow: Boolean = true
    private var isNewConfirmPasswordShow: Boolean = true
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
        mView = inflater.inflate(R.layout.fragment_change_password, container, false)
        setupToolbar()
        initUI()
        setupClickListener()
        return mView
    }

    private fun setupToolbar() {
        (activity as UserHomeActivity).setToolbarTitle(activity?.resources?.getString(R.string.change_password)!!)
        (activity as UserHomeActivity).setToolbarVisibility(true)
        (activity as UserHomeActivity).setToolbarMenuIconVisibility(false)
        (activity as UserHomeActivity).setToolbarBackIconVisibility(true)
    }

    private fun initUI() {
        mView?.et_oldPassword?.onFocusChangeListener =
                ChangePasswordEditTextFocusListener(activity!!, mView?.et_oldPassword!!, mView?.iv_oldPassword!!, mView?.lyt_oldPassword!!)
        mView?.et_newPassword?.onFocusChangeListener =
                ChangePasswordEditTextFocusListener(activity!!, mView?.et_newPassword!!, mView?.iv_newPassword!!, mView?.lyt_newPassword!!)
        mView?.et_confirmNewPassword?.onFocusChangeListener =
                ChangePasswordEditTextFocusListener(activity!!, mView?.et_confirmNewPassword!!, mView?.iv_confirmNewPassword!!, mView?.lyt_confirmNewPassword!!)
    }

    private fun setupClickListener() {
        mView?.iv_showHideOldPass?.setOnClickListener(this)
        mView?.iv_showHideNewPass?.setOnClickListener(this)
        mView?.iv_showHideConfirmNewPass?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_showHideOldPass ->
            {
                showHideOldPassword()
            }
            R.id.iv_showHideNewPass ->
            {
                showHideNewPassword()
            }
            R.id.iv_showHideConfirmNewPass ->
            {
                showHideNewConfirmPassword()
            }
        } 
    }

    private fun showHideOldPassword() {
        if (isOldPasswordShow) {
            isOldPasswordShow = false
            mView?.iv_showHideOldPass?.setImageResource(R.mipmap.eye_on_icon)
            mView?.et_oldPassword?.transformationMethod = HideReturnsTransformationMethod.getInstance()
        } else {
            isOldPasswordShow = true
            mView?.iv_showHideOldPass?.setImageResource(R.mipmap.eye_off_icon)
            mView?.et_oldPassword?.transformationMethod = PasswordTransformationMethod.getInstance()
        }
    }

    private fun showHideNewPassword() {
        if (isNewPasswordShow) {
            isNewPasswordShow = false
            mView?.iv_showHideNewPass?.setImageResource(R.mipmap.eye_on_icon)
            mView?.et_newPassword?.transformationMethod = HideReturnsTransformationMethod.getInstance()
        } else {
            isNewPasswordShow = true
            mView?.iv_showHideNewPass?.setImageResource(R.mipmap.eye_off_icon)
            mView?.et_newPassword?.transformationMethod = PasswordTransformationMethod.getInstance()
        }
    }

    private fun showHideNewConfirmPassword() {
        if (isNewConfirmPasswordShow) {
            isNewConfirmPasswordShow = false
            mView?.iv_showHideConfirmNewPass?.setImageResource(R.mipmap.eye_on_icon)
            mView?.et_confirmNewPassword?.transformationMethod = HideReturnsTransformationMethod.getInstance()
        } else {
            isNewConfirmPasswordShow = true
            mView?.iv_showHideConfirmNewPass?.setImageResource(R.mipmap.eye_off_icon)
            mView?.et_confirmNewPassword?.transformationMethod = PasswordTransformationMethod.getInstance()
        }
    }
}