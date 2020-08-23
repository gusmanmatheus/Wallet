package com.mathe.login.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.mathe.coreandroid.navigator
import com.mathe.login.R
import com.mathe.login.databinding.FragmentCongratulationsBinding
import com.mathe.login.navigation.CongratulationsNavigate
import org.koin.android.ext.android.inject

class CongratulationsFragment : Fragment() {
    val viewModel: CongratulationsViewModel by inject()
    private val congratulationsNavigate: CongratulationsNavigate by navigator()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val biding: FragmentCongratulationsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_congratulations, container, false)
        biding.lifecycleOwner = this
        biding.viewModel = viewModel
        setupObservers()
        viewModel.loggedUser()
        clickListener(biding)
        return biding.root

    }

    private fun setupObservers() {
        userObserve()
        goHomeScreenObserver()
    }

    private fun goHomeScreenObserver() {
        viewModel.goToHome.observe(viewLifecycleOwner, Observer {
            goToHomeScreen()
        })
    }

    private fun clickListener(binding: FragmentCongratulationsBinding) {
        binding.cgBtContinue.setOnClickListener {
            goToHomeScreen()
        }
    }

    private fun goToHomeScreen() {
        congratulationsNavigate.actionGoToHome()
    }

    private fun userObserve() {
        viewModel.user.observe(viewLifecycleOwner, Observer {
            val message = "${it.name}, ${requireContext().getString(R.string.congratulates_info)}"
            viewModel.setCongratsTextInfo(message)
        })
    }
}