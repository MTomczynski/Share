package com.maciejko.share

import android.app.Application
import com.maciejko.share.di.appModule
import org.koin.android.ext.android.startKoin

@Suppress("unused")
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(appModule))
    }
}