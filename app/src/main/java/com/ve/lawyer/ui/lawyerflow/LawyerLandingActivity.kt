package com.ve.lawyer.ui.lawyerflow

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.ve.lawyer.R
import com.ve.lawyer.ui.common.LoginActivity
import com.ve.lawyer.ui.common.base.BaseActivity
import com.ve.lawyer.utils.SlideAnimationUtil
import kotlinx.android.synthetic.main.activity_lawyer_landing.*

class LawyerLandingActivity : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lawyer_landing)

        setupUI()
        setupClickListener()
    }

    private fun setupUI()
    {

    }

    private fun setupClickListener()
    {
        btn_signIn.setOnClickListener(this)
        btn_signUp.setOnClickListener(this)
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
                moveToSignInScreen()
            }
            R.id.btn_signUp ->
            {
                moveToSignUpScreen()
            }
        }
    }

    private fun moveToSignInScreen()
    {
        val intent = Intent(this@LawyerLandingActivity, LoginActivity::class.java)
        startActivity(intent)
        SlideAnimationUtil.slideNextAnimation(this@LawyerLandingActivity)
    }

    private fun moveToSignUpScreen()
    {
        val intent = Intent(this@LawyerLandingActivity, LawyerSignUpActivity::class.java)
        startActivity(intent)
        SlideAnimationUtil.slideNextAnimation(this@LawyerLandingActivity)
    }
}