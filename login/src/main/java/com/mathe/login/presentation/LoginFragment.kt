package com.mathe.login.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mathe.login.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val bind = FragmentLoginBinding.inflate(inflater, container, false)
        setupClicksListers(bind)
        return bind.root
    }

    private fun setupClicksListers(bind: FragmentLoginBinding) {
        clickRegister(bind)
        clickLogin(bind)
    }

    private fun clickLogin(bind: FragmentLoginBinding) {
        bind.lgBtLogin.setOnClickListener {
         makeLogin()
        }
    }
    private fun makeLogin(){
        //TODO ainda sera implementado viewModel
    }

    private fun goToHomeScreen() {
        //TODO ainda sera implementada a navegacao

    }

    private fun clickRegister(bind: FragmentLoginBinding) {
        bind.lgBtRegister.setOnClickListener {
            goToRegisterScreen()
        }
    }

    private fun goToRegisterScreen() {
        //TODO ainda sera implementada a navegacao
    }


}
