package com.mathe.wallet

import android.app.Application
import com.mathe.login.modules.loginModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App() : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    loginModules
                )
            )
        }
    }
}