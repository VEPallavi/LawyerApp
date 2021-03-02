package com.ve.lawyer.ui.common

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.ve.lawyer.R
import com.ve.lawyer.ui.common.base.BaseActivity
import com.ve.lawyer.ui.lawyerflow.LawyerLandingActivity
import com.ve.lawyer.ui.userflow.UserLandingActivity
import com.ve.lawyer.utils.AppConstants
import com.ve.lawyer.utils.SlideAnimationUtil
import kotlinx.android.synthetic.main.activity_user_type.*

class UserTypeSelectionActivity : BaseActivity(), View.OnClickListener {

    private var mUserType: String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_type)

        setupUI()
        setupClickListener()
        manageUserTypeSelection(AppConstants.CLIENT_USER_TYPE)
    }

    private fun setupUI()
    {

    }

    private fun setupClickListener()
    {
        back.setOnClickListener(this)
        client_checkbox.setOnClickListener(this)
        law_checkbox.setOnClickListener(this)
        btn_next.setOnClickListener(this)
        lyt_client.setOnClickListener(this)
        lyt_lawyer.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id)
        {
            R.id.back ->
            {
                onBackPressed()
            }
            R.id.client_checkbox ->
            {
                manageUserTypeSelection(AppConstants.CLIENT_USER_TYPE)
            }
            R.id.law_checkbox ->
            {
                manageUserTypeSelection(AppConstants.LAWYER_USER_TYPE)
            }
            R.id.lyt_client ->
            {
                manageUserTypeSelection(AppConstants.CLIENT_USER_TYPE)
            }
            R.id.lyt_lawyer ->
            {
                manageUserTypeSelection(AppConstants.LAWYER_USER_TYPE)
            }
            R.id.btn_next ->
            {
                moveToNext()
            }
        }
    }

    private fun manageUserTypeSelection(userType: String)
    {
        lyt_client.background = ContextCompat.getDrawable(this@UserTypeSelectionActivity, R.drawable.bg_user_unselect)
        lyt_lawyer.background = ContextCompat.getDrawable(this@UserTypeSelectionActivity, R.drawable.bg_user_unselect)

        client_checkbox.setImageResource(R.mipmap.uncheck_icon)
        law_checkbox.setImageResource(R.mipmap.uncheck_icon)

        when(userType)
        {
            AppConstants.CLIENT_USER_TYPE ->
            {
                mUserType = AppConstants.CLIENT_USER_TYPE
                lyt_client.background = ContextCompat.getDrawable(this@UserTypeSelectionActivity, R.drawable.bg_user_select)
                client_checkbox.setImageResource(R.mipmap.check_icon)
            }
            AppConstants.LAWYER_USER_TYPE ->
            {
                mUserType = AppConstants.LAWYER_USER_TYPE
                lyt_lawyer.background = ContextCompat.getDrawable(this@UserTypeSelectionActivity, R.drawable.bg_user_select)
                law_checkbox.setImageResource(R.mipmap.check_icon)
            }
        }
    }

    private fun moveToNext()
    {
        var intent: Intent? = null
        when(mUserType)
        {
            AppConstants.CLIENT_USER_TYPE ->
            {
                intent = Intent(this@UserTypeSelectionActivity, UserLandingActivity::class.java)
            }
            AppConstants.LAWYER_USER_TYPE ->
            {
                intent = Intent(this@UserTypeSelectionActivity, LawyerLandingActivity::class.java)
            }
        }
        startActivity(intent)
        finish()
        SlideAnimationUtil.slideNextAnimation(this@UserTypeSelectionActivity)
    }
}