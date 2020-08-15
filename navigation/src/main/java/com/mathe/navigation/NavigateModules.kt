package com.mathe.navigation

import androidx.fragment.app.Fragment
import com.mathe.login.navigation.LoginNavigate
import org.koin.dsl.module

val navigateModules = module {
    factory<LoginNavigate> { (fragment: Fragment) -> LoginNavigateImpl(fragment)  }
}