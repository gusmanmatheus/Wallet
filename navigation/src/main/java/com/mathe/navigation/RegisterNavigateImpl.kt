package com.mathe.navigation

import androidx.fragment.app.Fragment
import com.mathe.login.navigation.RegisterNavigate
import com.mathe.login.presentation.RegisterFragmentDirections.Companion.actionRegisterFragmentToCongratulationsFragment
import com.mathe.navigation.utils.navigate

class RegisterNavigateImpl(private val fragment: Fragment) : RegisterNavigate {
    override fun actionGoCongratulation() {
        fragment.navigate(actionRegisterFragmentToCongratulationsFragment())
    }
}