package com.mathe.coreandroid.datasource.local

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

    override suspend fun findUserByUsername(username: String): Long? {
        return userDao.findUserByUsername(username)
    }

    override suspend fun logout() {
        userDao.logout()
    }

    override suspend fun login(id: Long): Int {
        return userDao.login(id)
    }

    override suspend fun getActiveUser(): User? {
        return userDao.getActiveUser()?.toUser()
    }


    private fun UserEntity.toUser() = User(id, username, name, password, active
    )

    private fun User.toUserEntity() =
        UserEntity(username = username, name = name, password = password, active = active)

}