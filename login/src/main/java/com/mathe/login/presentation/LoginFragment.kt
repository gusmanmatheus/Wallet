package com.mathe.login.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.mathe.coreandroid.navigator
import com.mathe.login.R
import com.mathe.login.databinding.FragmentLoginBinding
import com.mathe.login.databinding.FragmentRegisterBinding
import com.mathe.login.navigation.LoginNavigate
import org.koin.android.ext.android.inject


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
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel
        setupClicksListers(binding)
        setupObservers(binding)
        return binding.root
    }

    private fun setupClicksListers(binding: FragmentLoginBinding) {
        clickRegister(binding)
        clickLogin(binding)

    }

    private fun setupObservers(binding: FragmentLoginBinding) {
        goToHomeScreenObserver()
        errorObserver()
        usernameObserver(binding)
        passwordObserver(binding)
    }

    private fun errorObserver() {
        viewModel.error.observe(this, Observer {
            Toast.makeText(
                requireContext(),
                "Erro ao logar, verifique usuario e senha",
                Toast.LENGTH_SHORT
            ).show()
        })
    }

    private fun clickLogin(binding: FragmentLoginBinding) {
        binding.lgBtLogin.setOnClickListener {
            viewModel.login()
        }
    }

    private fun goToHomeScreenObserver() {
        viewModel.goToHomeScreen.observe(this, Observer {
            if (it) {
                goToHomeScreen()
            }
        })
    }

    private fun goToHomeScreen() {
        // vai pra proxima tela
    }

    private fun clickRegister(binding: FragmentLoginBinding) {
        binding.lgBtRegister.setOnClickListener {
            goToRegisterScreen()
        }
    }

    private fun goToRegisterScreen() {
        loginNavigate.actionRegister()
    }

    private fun usernameObserver(binding: FragmentLoginBinding) {
        viewModel.username.observe(this, Observer {
            controlButton(binding)
        })
    }

    private fun passwordObserver(binding: FragmentLoginBinding) {
        viewModel.password.observe(this, Observer {
            controlButton(binding)
        })
    }

    private fun controlButton(binding: FragmentLoginBinding) {
        binding.lgBtLogin.isEnabled =
            !viewModel.username.value.isNullOrBlank() && !viewModel.password.value.isNullOrBlank()
    }

}
