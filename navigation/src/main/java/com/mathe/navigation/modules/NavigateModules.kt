package com.mathe.navigation.modules

import androidx.fragment.app.Fragment
import com.mathe.login.navigation.LoginNavigate
import com.mathe.login.navigation.RegisterNavigate
import com.mathe.navigation.LoginNavigateImpl
import com.mathe.navigation.RegisterNavigateImpl
import org.koin.dsl.module

val navigateModules = module {
    factory<LoginNavigate> { (fragment: Fragment) ->
        LoginNavigateImpl(
            fragment
        )
    }

    factory<RegisterNavigate> { (fragment: Fragment) ->
        RegisterNavigateImpl(
            fragment
        )
    }
}