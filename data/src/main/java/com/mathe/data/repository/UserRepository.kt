package com.mathe.data.repository

 import com.mathe.domain.User
 import com.mathe.domain.datasource.UserDataSource

class UserRepository(private val userDataSource: UserDataSource): UserDataSource {
    override  suspend fun authenticateUser(username: String, password: String):User? {
        return userDataSource.authenticateUser(username, password)
    }

    override suspend fun findUserByUsername(username: String): Long? {
        return userDataSource.findUserByUsername(username)
    }

    override suspend fun registerUser(user: User):Long {
        return userDataSource.registerUser(user)
    }
}