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
        val biding: FragmentRegisterBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_register,
                container,
                false
            )
        biding.viewModel = this.viewModel
        biding.lifecycleOwner = viewLifecycleOwner
         validateRegister(biding)
        setupObservers()
        return biding.root
    }
    private fun setupObservers(){
        errorObserver()
        goToCongratulationsObserver()
    }
    private fun validateRegister(binding: FragmentRegisterBinding){
        binding.rgBtRegister.setOnClickListener {
                viewModel.registerUser()
        }
        }

    private fun errorObserver() {
        viewModel.error.observe(this, Observer {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        })
    }
    private fun goToCongratulationsObserver(){
        viewModel.goToCongratulationScreen.observe(this, Observer {
            if(it){
                goToCongratulationsScreen()
            }
        })
    }

    private fun goToCongratulationsScreen() {
    registerNavigate.actionGoCongratulation()
    }
}


