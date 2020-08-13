package com.example.coreandroid.datasource

import com.example.coreandroid.db.UserDao
import com.example.coreandroid.db.model.UserEntity
import com.example.data.datasource.UserDataSource
import com.example.domain.User

class RoomUserDataSource(private val userDao: UserDao) :
    UserDataSource {

    override suspend fun registerUser(user: User): Boolean {

        return userDao.register(user.toUserEntity())
    }

    override suspend fun login(username: String, password: String): User? {
        return userDao.getUser(username, password)?.toUser()
    }

    private fun UserEntity.toUser() = User(username, name, password)

    private fun User.toUserEntity() = UserEntity(username, name, password)

}