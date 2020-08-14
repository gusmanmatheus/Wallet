package com.mathe.login.modules

import androidx.room.Room
import androidx.room.RoomDatabase
import com.mathe.coreandroid.datasource.RoomUserDataSource
import com.mathe.data.LoginUser
import com.mathe.data.datasource.UserDataSource
import com.mathe.data.repository.UserRepository
import com.mathe.login.presentation.LoginViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

val loginModules = module {
    factory { LoginUser(get()) }

    factory { UserRepository(get()) }

    factory<UserDataSource>() { RoomUserDataSource(get()) }

    factory {
        single {
            Room.databaseBuilder(get(), RoomDatabase::class.java, "database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        } bind RoomDatabase::class
    }

     viewModel { LoginViewModel() }
}