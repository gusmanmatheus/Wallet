package com.mathe.navigation

import androidx.fragment.app.Fragment
import com.mathe.login.navigation.CongratulationsNavigate
import com.mathe.login.presentation.CongratulationsFragmentDirections.Companion.actionCongratulationsFragmentToHomeFragment
import com.mathe.navigation.utils.navigate

class CongratulationsNavigateImpl(private val fragment: Fragment) : CongratulationsNavigate{
    override fun actionGoToHome() {
        fragment.navigate(actionCongratulationsFragmentToHomeFragment())
    }
}