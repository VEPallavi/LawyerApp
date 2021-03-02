package com.ve.lawyer.ui.listener

import android.content.Context
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.ve.lawyer.R

class EditTextFocusListener(context: Context, view: EditText, leftIcon: ImageView, lyt: ConstraintLayout): View.OnFocusChangeListener {

    private var mContext: Context? = null
    private var mEditText: EditText? = null
    private var mLeftIcon: ImageView? = null
    private var mLyt: ConstraintLayout? = null

    init {
        this.mContext = context
        this.mEditText = view
        this.mLeftIcon = leftIcon
        this.mLyt = lyt
    }

    override fun onFocusChange(v: View?, hasFocus: Boolean) {
        when(v?.id)
        {
            R.id.et_loginEmail ->
            {
                if (hasFocus)
                {
                    mLeftIcon?.setImageResource(R.mipmap.email_on_icon)
                    mLyt?.setBackgroundResource(R.drawable.bg_solid_white_rounded_blue_border)
                }
                else
                {
                    if (TextUtils.isEmpty(mEditText?.text.toString().trim()))
                    {
                        mLeftIcon?.setImageResource(R.mipmap.email_off_icon)
                        mLyt?.setBackgroundResource(R.drawable.bg_solid_white_rounded_corner)
                    }
                }
            }
            R.id.et_forgotEmail ->
            {
                if (hasFocus)
                {
                    mLeftIcon?.setImageResource(R.mipmap.email_on_icon)
                    mLyt?.setBackgroundResource(R.drawable.bg_solid_white_rounded_blue_border)
                }
                else
                {
                    if (TextUtils.isEmpty(mEditText?.text.toString().trim()))
                    {
                        mLeftIcon?.setImageResource(R.mipmap.email_off_icon)
                        mLyt?.setBackgroundResource(R.drawable.bg_solid_white_rounded_corner)
                    }
                }
            }
            R.id.et_loginPassword ->
            {
                if (hasFocus)
                {
                    mLeftIcon?.setImageResource(R.mipmap.lock_on_icon)
                    mLyt?.setBackgroundResource(R.drawable.bg_solid_white_rounded_blue_border)
                }
                else
                {
                    if (TextUtils.isEmpty(mEditText?.text.toString().trim()))
                    {
                        mLeftIcon?.setImageResource(R.mipmap.lock_off_icon)
                        mLyt?.setBackgroundResource(R.drawable.bg_solid_white_rounded_corner)
                    }
                }
            }
        }
    }
}