package com.mathe.data.repository

import com.mathe.data.datasource.UserDataSource
import com.mathe.domain.User

class UserRepository(private val userDataSource: UserDataSource) {
    suspend fun login(username: String, password: String):User? {
        return userDataSource.login(username, password)
    }

    suspend fun register(user: User):Boolean {
        return userDataSource.registerUser(user)
    }
}