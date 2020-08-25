package com.mathe.navigation

import androidx.fragment.app.Fragment
import com.example.home.navigate.HomeNavigate
import com.example.home.presentation.HomeFragment
import com.example.home.presentation.HomeFragmentDirections
import com.example.home.presentation.HomeFragmentDirections.Companion.actionHomeFragmentToLoginFragment
import com.example.home.presentation.HomeFragmentDirections.Companion.actionHomeFragmentToReceiptFragment
import com.mathe.navigation.utils.navigate

class HomeNavigateImpl(val fragment:Fragment):HomeNavigate {
    override fun goToReceiptScreen() {
        fragment.navigate(actionHomeFragmentToReceiptFragment())
    }
    override fun logout(){
        fragment.navigate(actionHomeFragmentToLoginFragment())
    }
}