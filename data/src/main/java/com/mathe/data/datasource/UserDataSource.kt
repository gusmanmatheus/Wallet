package com.mathe.data.datasource

import com.mathe.domain.User

interface UserDataSource {
    suspend fun registerUser(user: User): Long
    suspend fun authenticateUser(username: String, password: String): User?
    suspend fun findUserByUsername(username: String):Long?
}