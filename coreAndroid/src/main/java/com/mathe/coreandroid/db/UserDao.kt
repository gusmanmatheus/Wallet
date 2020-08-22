package com.mathe.coreandroid.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mathe.coreandroid.db.model.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM USER WHERE USERNAME = :username AND PASSWORD = :password")
    suspend fun authenticateUser(username: String, password: String): UserEntity?

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun register(user: UserEntity): Long

    @Query("SELECT id FROM USER WHERE USERNAME = :username")
    suspend fun findUserByUsername(username: String): Long?

    @Query("UPDATE USER SET ACTIVE = 0")
    suspend fun logout()

    @Query("UPDATE USER SET ACTIVE = 1 WHERE ID=:id")
    suspend fun login(id: Long):Int

    @Query("SELECT * FROM USER WHERE ACTIVE = 1")
    suspend fun getActiveUser(): UserEntity?
}