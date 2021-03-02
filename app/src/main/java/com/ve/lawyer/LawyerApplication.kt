package com.ve.lawyer

import android.app.Application
import android.content.ContextWrapper
import com.ve.lawyer.prefrences.Prefs

class LawyerApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(packageName)
                .setUseDefaultSharedPreference(true)
                .build()
    }
}