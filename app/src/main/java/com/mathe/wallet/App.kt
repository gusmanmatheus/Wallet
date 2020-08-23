package com.mathe.wallet

import android.app.Application
import com.example.home.homeModules
import com.mathe.coreandroid.coreApiModules
import com.mathe.login.modules.loginModules
import com.mathe.navigation.modules.navigateModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App() : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    loginModules,
                    navigateModules,
                    coreApiModules,
                    homeModules
                )
            )
        }
    }
}

