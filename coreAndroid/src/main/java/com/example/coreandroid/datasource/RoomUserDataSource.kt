package com.example.coreandroid.datasource

import com.example.coreandroid.db.UserDao
import com.example.coreandroid.db.model.UserEntity
import com.example.data.datasource.UserDataSource
import com.example.domain.User

class RoomUserDataSource(private val userDao: UserDao) :
    UserDataSource {

    override suspend fun registerUser(user: User): Boolean {
        return userDao.register(UserEntity(user.username, user.name, user.password))
    }

    override suspend fun login(username: String, password: String): User? {
        val userEntity = userDao.getUser(username, password)
        userEntity?.let {
            return User(userEntity.username, userEntity.name, userEntity.password)
        }
        return null
    }
}