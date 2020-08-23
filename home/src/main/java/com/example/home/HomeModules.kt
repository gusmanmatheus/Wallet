package com.example.home

import com.example.home.presentation.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModules = module {
    factory { HomeInteractor(get(), get(), get(), get(), get()) }
    viewModel { HomeViewModel(get()) }
}