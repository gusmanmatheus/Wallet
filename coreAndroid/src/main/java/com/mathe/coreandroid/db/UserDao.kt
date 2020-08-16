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
    suspend fun findUserByUsername(username: String):Long?
}