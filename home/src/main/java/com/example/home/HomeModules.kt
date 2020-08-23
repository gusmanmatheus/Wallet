package com.example.home

import com.example.home.presentation.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModules = module {
    factory {
        HomeInteractor(
            getWallet = get(),
            updateWallet = get(),
            getQuotationDollar = get(),
            getQuotationBitcoin = get(),
            userActive = get()
        )
    }
    viewModel { HomeViewModel(homeInteractor = get()) }
}