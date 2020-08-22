package com.mathe.navigation

import androidx.fragment.app.Fragment
import com.mathe.login.navigation.LoginNavigate
import com.mathe.login.presentation.LoginFragmentDirections.Companion.actionLoginFragmentToHomeFragment
import com.mathe.login.presentation.LoginFragmentDirections.Companion.actionLoginFragmentToRegisterFragment
import com.mathe.navigation.utils.navigate

class LoginNavigateImpl(private val fragment: Fragment) : LoginNavigate {
    override fun actionLogin() {
        fragment.navigate(actionLoginFragmentToHomeFragment())
    }

    override fun actionRegister() {
        fragment.navigate(actionLoginFragmentToRegisterFragment())
    }

}

