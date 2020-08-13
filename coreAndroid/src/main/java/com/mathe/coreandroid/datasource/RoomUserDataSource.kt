package com.mathe.coreandroid.datasource

import com.mathe.coreandroid.db.UserDao
import com.mathe.coreandroid.db.model.UserEntity
import com.mathe.data.datasource.UserDataSource
import com.mathe.domain.User

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