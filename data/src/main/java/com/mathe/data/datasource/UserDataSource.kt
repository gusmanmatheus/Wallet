package com.mathe.data.datasource

import com.mathe.domain.User

interface UserDataSource {
    suspend fun registerUser(user: User): Boolean
    suspend fun login(username: String, password: String): User?
}