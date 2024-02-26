package com.moonila

import android.app.Application
import org.koin.android.ext.koin.androidContext
import umbrella.MoonilaSDK

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initSDK()
    }
}

internal fun MainApplication.initSDK() =
    MoonilaSDK.init {
        androidContext(androidContext = this@initSDK)
    }