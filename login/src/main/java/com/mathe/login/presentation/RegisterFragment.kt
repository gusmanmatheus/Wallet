package com.mathe.login.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.mathe.coreandroid.navigator
import com.mathe.login.R
import com.mathe.login.databinding.FragmentRegisterBinding
import com.mathe.login.navigation.RegisterNavigate
import org.koin.android.viewmodel.ext.android.viewModel

class RegisterFragment : Fragment() {

    private val registerNavigate: RegisterNavigate by navigator()
    private val viewModel: RegisterViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentRegisterBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_register,
                container,
                false
            )
        binding.viewModel = this.viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        validateRegister(binding)
        setupObservers(binding)
        return binding.root
    }

    private fun setupObservers(binding: FragmentRegisterBinding) {
        errorObserver()
        goToCongratulationsObserver()
        usernameObserver(binding)
        passwordObserver(binding)
    }

    private fun validateRegister(binding: FragmentRegisterBinding) {
        binding.rgBtRegister.setOnClickListener {
            viewModel.registerUser()
        }
    }

    private fun usernameObserver(binding: FragmentRegisterBinding) {
        viewModel.username.observe(this, Observer {
            controlButton(binding)
        })
    }

    private fun passwordObserver(binding: FragmentRegisterBinding) {
        viewModel.password.observe(this, Observer {
            controlButton(binding)
        })
    }

    private fun controlButton(binding: FragmentRegisterBinding) {
        binding.rgBtRegister.isEnabled =
            !viewModel.username.value.isNullOrBlank() && !viewModel.password.value.isNullOrBlank()
    }

    private fun errorObserver() {
        viewModel.error.observe(this, Observer {
            val message = if (it == 1) "erro Inesperado" else "usuario ja cadastrado"
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        })
    }

    private fun goToCongratulationsObserver() {
        viewModel.goToCongratulationScreen.observe(this, Observer {
            if (it) {
                goToCongratulationsScreen()
                viewModel.resetRoute()
            }   })
    }

    private fun goToCongratulationsScreen() {
        registerNavigate.actionGoCongratulation()
    }
}


