package com.example.data.datasource

import com.example.domain.User

interface UserDataSource {
    suspend fun registerUser(user: User): Boolean
    suspend fun login(username: String, password: String): User?
}