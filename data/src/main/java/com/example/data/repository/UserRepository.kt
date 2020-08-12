package com.example.data.repository

import com.example.data.datasource.UserDataSource

class UserRepository(private val userDataSource: UserDataSource) {
    suspend fun login() {
        userDataSource.login()
    }

    suspend fun register() {
        userDataSource.registerUser()
    }
}