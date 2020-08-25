package com.mathe.data.repository.local

import com.mathe.domain.User
import com.mathe.domain.datasource.UserDataSource

class UserRepository(private val userDataSource: UserDataSource) : UserDataSource {
    override suspend fun authenticateUser(username: String, password: String): User? {
        return userDataSource.authenticateUser(username, password)
    }

    override suspend fun findUserByUsername(username: String): Long? {
        return userDataSource.findUserByUsername(username)
    }

    override suspend fun logout() {
        userDataSource.logout()
    }

    override suspend fun login(id: Long): Int {
        return userDataSource.login(id)
    }

    override suspend fun getActiveUser(): User? {
        return userDataSource.getActiveUser()
    }

    override suspend fun registerUser(user: User): Long {
        return userDataSource.registerUser(user)
    }
}