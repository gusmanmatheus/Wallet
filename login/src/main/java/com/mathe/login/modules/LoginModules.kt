package com.mathe.login.modules

import com.mathe.data.repository.local.UserRepository
import com.mathe.data.usercaselogin.*
import com.mathe.login.CongratulationsInteractor
import com.mathe.login.LoginInteractor
import com.mathe.login.RegisterInteractor
import com.mathe.login.presentation.CongratulationsViewModel
import com.mathe.login.presentation.LoginViewModel
import com.mathe.login.presentation.RegisterViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginModules = module {

    factory {
        LoginInteractor(
            authenticate = get(),
            findUserId = get(),
            getActiveUser = get(),
            login = get()
        )
    }
    factory {
        RegisterInteractor(
            register = get(),
            findUserId = get(),
            login = get()
        )
    }
    factory {
        CongratulationsInteractor(
            getActiveUser = get(),
            createNewWallet = get()
        )
    }

    viewModel { LoginViewModel(loginInteractor = get()) }
    viewModel { RegisterViewModel(registerInteractor = get()) }
    viewModel { CongratulationsViewModel(congratulationsInteractor = get()) }
}
