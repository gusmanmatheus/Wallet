package com.mathe.coreandroid.datasource

import com.mathe.coreandroid.db.UserDao
import com.mathe.coreandroid.db.model.UserEntity
import com.mathe.domain.datasource.UserDataSource
import com.mathe.domain.User

class RoomUserDataSource(private val userDao: UserDao) :
    UserDataSource {

    override suspend fun registerUser(user: User): Long {
        return userDao.register(user.toUserEntity())
    }

    override suspend fun authenticateUser(username: String, password: String): User? {
        return userDao.authenticateUser(username, password)?.toUser()
    }

    override suspend fun findUserByUsername(username: String):Long?{
        return userDao.findUserByUsername(username)
    }

    private fun UserEntity.toUser() = User(username, name, password)

    private fun User.toUserEntity() = UserEntity(username=  username,name =  name, password = password)

}