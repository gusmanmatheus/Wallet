package com.example.home.presentation

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.home.R
import com.example.home.databinding.FragmentHomeBinding
import com.mathe.core.interactors.cleanMoneyText
import com.mathe.coreandroid.maskValue
import org.koin.android.viewmodel.ext.android.viewModel


class HomeFragment : Fragment(), AdapterView.OnItemSelectedListener {
    var control = true
    val viewModel: HomeViewModel by viewModel()
    lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        setupObserver()
        setupScreen()
        clickTrade()
        return binding.root
    }

    private fun setupObserver() {
        userObserver()
        walletObserver()
        exchangeObservable()
        errorBitcoin()
        errorBritta()
        insufficientFundsObserver()

    }

    private fun setupScreen() {
        viewModel.getQuotations()
        viewModel.getUserActive()
    }

    private fun userObserver() {
        viewModel.user.observe(viewLifecycleOwner, Observer {
            viewModel.getWallet()
            fillUser()
        })
    }

    private fun fillUser() {
        binding.hmTvName.text = "olá ${viewModel.user.value?.name}"
    }

    private fun walletObserver() {
        viewModel.wallet.observe(viewLifecycleOwner, Observer {
            viewModel.setValuesCoinsTexts()
            setupSpinner()
        })
    }

    private fun setupSpinner() {
        val adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.convertQuotations,
            R.layout.support_simple_spinner_dropdown_item
        )
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        binding.hmSpnQuotations.adapter = adapter
        binding.hmSpnQuotations.onItemSelectedListener = this
    }

    private fun exchangeObservable() {

        viewModel.exchangeSpent.observe(this, Observer {
            if (control) {
              viewModel.exchangeSpent.value =  binding.hmEdExchange.maskValue()
                control = false
                viewModel.convertQuotation()
                binding.hmEdExchange.setSelection(binding.hmEdExchange.text.length )

            } else {
                control = true
            }
        })
    }
    private fun clickTrade() {
        binding.hmBtTrade.setOnClickListener {
            val verifyVoid = (viewModel.exchangeSpent.value?.cleanMoneyText() ?: 0.0)
            if (verifyVoid > 0.0)
                viewModel.updateWallet()
            else
                popUpErro("Digite um valor")
        }
    }

    override fun onNothingSelected(binparent: AdapterView<*>?) {
        binding.hmBtTrade.isEnabled = false
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
        binding.hmBtTrade.isEnabled = true
        viewModel.selectedTrade.value = parent.getItemAtPosition(position).toString()
        viewModel.convertQuotation()
    }

    private fun errorBritta() {
        viewModel.errorBitcoin.observe(this, Observer {
            binding.hmSpnQuotations.isEnabled = false
            binding.hmBtTrade.isEnabled = false
            binding.hmEdExchange.isEnabled = false
            popUpErro(
                getString(R.string.error_request_cambio)
            )

        })
    }

    private fun errorBitcoin() {
        viewModel.errorBritta.observe(this, Observer {
            binding.hmSpnQuotations.isEnabled = false
            binding.hmBtTrade.isEnabled = false
            binding.hmEdExchange.isEnabled = false
            popUpErro(
                getString(R.string.error_request_cambio)
            )
        })
    }

    private fun insufficientFundsObserver() {
        viewModel.insufficientFunds.observe(this, Observer {
            if (it) {
                popUpErro(getString(R.string.no_money_balance))
            }
        })
    }

    private fun popUpErro(message: String) {
        val alertDialog = AlertDialog.Builder(requireContext())
        alertDialog.setTitle(
            "erro"
        )
        alertDialog.setMessage(message)
        alertDialog.setPositiveButton("Ok") { _, _ ->
        }
        alertDialog.show()
    }

}


