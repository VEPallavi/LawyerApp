package com.ve.lawyer.utils

import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class ToastMsgUtils {
    companion object{
        fun showSuccessMsg(view: View, message: String){
            val snackbar = Snackbar.make(view, message,
                    Snackbar.LENGTH_LONG)
            //snackbar.setActionTextColor(Color.BLUE)
            val snackbarView = snackbar.view
            snackbarView.setBackgroundColor(Color.parseColor("#4371ca"))
            val textView = snackbarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
            textView.setTextColor(Color.WHITE)
            textView.textSize = 16f
            snackbar.show()
        }

        fun showErrorMsg(view: View, message: String){
            val snackbar = Snackbar.make(view, message,
                    Snackbar.LENGTH_LONG)
            val snackbarView = snackbar.view
            snackbarView.setBackgroundColor(Color.parseColor("#4371ca"))
            val textView = snackbarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
            textView.setTextColor(Color.WHITE)
            textView.textSize = 16f
            snackbar.show()
        }

        fun showSuccessToastMsg(context: Context, message: String)
        {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }
}