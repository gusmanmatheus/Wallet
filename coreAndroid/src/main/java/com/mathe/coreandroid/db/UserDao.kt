package com.mathe.coreandroid.db

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mathe.coreandroid.db.model.UserEntity

interface UserDao {
    @Query("SELECT * FROM USER WHERE USERNAME = :username AND PASSWORD = :password")
    suspend fun getUser(username: String, password: String): UserEntity?

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun register(user: UserEntity): Boolean

}