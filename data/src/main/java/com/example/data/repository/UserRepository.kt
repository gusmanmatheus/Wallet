package com.example.data.repository

import com.example.data.datasource.UserDataSource
import com.example.domain.User

class UserRepository(private val userDataSource: UserDataSource) {
    suspend fun login(username: String, password: String):User? {
        return userDataSource.login(username, password)
    }

    suspend fun register(user: User):Boolean {
        return userDataSource.registerUser(user)
    }
}