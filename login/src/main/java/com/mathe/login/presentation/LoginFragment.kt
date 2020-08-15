package com.mathe.login.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.mathe.coreandroid.navigator
import com.mathe.login.R
import com.mathe.login.databinding.FragmentLoginBinding
import com.mathe.login.navigation.LoginNavigate
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


class LoginFragment : Fragment() {

    val viewModel: LoginViewModel by inject()
    private val loginNavigate: LoginNavigate by navigator()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentLoginBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_login,
                container,
                false
            )
        setupClicksListers(binding)
        return binding.root
    }

    private fun setupClicksListers(binding: FragmentLoginBinding) {
        clickRegister(binding)
        clickLogin(binding)
    }

    private fun clickLogin(bind: FragmentLoginBinding) {
        bind.lgBtLogin.setOnClickListener {
            makeLogin()
        }
    }

    private fun makeLogin() {

    }

    private fun goToHomeScreen() {

    }

    private fun clickRegister(bind: FragmentLoginBinding) {
        bind.lgBtRegister.setOnClickListener {
            goToRegisterScreen()
        }
    }

    private fun goToRegisterScreen() {
        loginNavigate.actionRegister()
    }


}
