package com.mathe.login.modules

import androidx.room.Room
import com.mathe.coreandroid.datasource.RoomUserDataSource
import com.mathe.coreandroid.db.WalletDataBase
import com.mathe.data.usercaselogin.AuthenticateUser
import com.mathe.data.usercaselogin.RegisterUser
import com.mathe.domain.datasource.UserDataSource
import com.mathe.data.repository.UserRepository
import com.mathe.data.usercaselogin.FindUserId
import com.mathe.login.LoginInteractor
import com.mathe.login.presentation.LoginViewModel
import com.mathe.login.presentation.RegisterViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

val loginModules = module {

    single {
        Room.databaseBuilder(get(), WalletDataBase::class.java, "database")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    } bind WalletDataBase::class

    factory { FindUserId(get()) }

    factory { LoginInteractor(get(), get(), get()) }

    factory { RegisterUser(get()) }

    factory { AuthenticateUser(get()) }

    factory { UserRepository(get()) }

    factory<UserDataSource> { RoomUserDataSource(get()) }

    factory {
        get<WalletDataBase>().userDao()
    }


    viewModel { LoginViewModel(get()) }
    viewModel { RegisterViewModel(get()) }
}