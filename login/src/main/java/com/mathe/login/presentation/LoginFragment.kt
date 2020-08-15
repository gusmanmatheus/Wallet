package com.mathe.login.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.mathe.coreandroid.navigator
import com.mathe.login.R
import com.mathe.login.databinding.FragmentLoginBinding
import com.mathe.login.navigation.LoginNavigate
import org.koin.android.ext.android.inject


class LoginFragment : Fragment() {

    val viewModel: LoginViewModel by inject()
    private val loginNavigate: LoginNavigate by navigator()
    lateinit var binding: FragmentLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_login,
                container,
                false
            )
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel
        setupClicksListers()
        setupObservers()
        return binding.root
    }

    private fun setupClicksListers() {
        clickRegister()
        clickLogin()

    }

    private fun setupObservers() {
        goToHomeScreenObserver()
        errorObserver()
    }

    private fun errorObserver() {
        viewModel.error.observe(this, Observer {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        })
    }

    private fun clickLogin() {
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

    private fun clickRegister() {
        binding.lgBtRegister.setOnClickListener {
            goToRegisterScreen()
        }
    }

    private fun goToRegisterScreen() {
        loginNavigate.actionRegister()
    }


}
