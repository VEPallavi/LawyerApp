package com.ve.lawyer.ui.common

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.ve.lawyer.R
import com.ve.lawyer.utils.SlideAnimationUtil

class SplashActivity : AppCompatActivity() {

    private var DELAY_TIME : Long =  1500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
//            if (!Prefs.getString(AppConstant.USER_ID).isEmpty()) {
//                startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
//            } else {
//                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
//            }
            startActivity(Intent(this@SplashActivity, UserTypeSelectionActivity::class.java))
            finish()
            SlideAnimationUtil.slideNextAnimation(this@SplashActivity)
        },DELAY_TIME)
    }
}