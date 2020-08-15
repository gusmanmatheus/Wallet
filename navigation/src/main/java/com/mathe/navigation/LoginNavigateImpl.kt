package com.mathe.navigation

import androidx.fragment.app.Fragment
import com.mathe.login.navigation.LoginNavigate
import com.mathe.login.presentation.LoginFragmentDirections
import com.mathe.navigation.utils.navigate

class LoginNavigateImpl(private val fragment: Fragment): LoginNavigate {
    override fun actionLogin() {
       }

    override fun actionRegister() {
        fragment.navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
     }

}

