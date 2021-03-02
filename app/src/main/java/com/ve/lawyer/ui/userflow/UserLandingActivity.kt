package com.ve.lawyer.ui.userflow

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.ve.lawyer.R
import com.ve.lawyer.ui.common.LoginActivity
import com.ve.lawyer.ui.common.base.BaseActivity
import com.ve.lawyer.utils.SlideAnimationUtil
import kotlinx.android.synthetic.main.activity_user_landing.*

class UserLandingActivity : BaseActivity(), View.OnClickListener, OnMapReadyCallback {

    private var mGoogleMap: GoogleMap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_landing)

        setupUI()
        setupClickListener()
    }

    private fun setupUI()
    {
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun setupClickListener()
    {
        btn_signIn.setOnClickListener(this)
        btn_signUp.setOnClickListener(this)
        btn_legalBasicQuestion.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id)
        {
            R.id.btn_signIn ->
            {
                moveToLoginScreen()
            }
            R.id.btn_signUp ->
            {
                moveToSignUpScreen()
            }
            R.id.btn_legalBasicQuestion ->
            {
                moveToHomeScreen()
            }
        }
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        mGoogleMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mGoogleMap?.addMarker(MarkerOptions()
                .position(sydney)
                .title("Marker in Sydney"))
        mGoogleMap?.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

    private fun moveToLoginScreen()
    {
        val intent = Intent(this@UserLandingActivity, LoginActivity::class.java)
        startActivity(intent)
        SlideAnimationUtil.slideNextAnimation(this@UserLandingActivity)
    }

    private fun moveToSignUpScreen()
    {
        val intent = Intent(this@UserLandingActivity, UserSignUpActivity::class.java)
        startActivity(intent)
        SlideAnimationUtil.slideNextAnimation(this@UserLandingActivity)
    }

    private fun moveToHomeScreen()
    {
        val intent = Intent(this@UserLandingActivity, UserLandingActivity::class.java)
        startActivity(intent)
        SlideAnimationUtil.slideNextAnimation(this@UserLandingActivity)
    }
}