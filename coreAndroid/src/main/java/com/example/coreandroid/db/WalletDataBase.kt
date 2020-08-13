package com.example.coreandroid.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.coreandroid.db.model.UserEntity

@Database(
    entities = [UserEntity::class],
    version = 1
)
abstract class WalletDataBase() : RoomDatabase() {
    abstract fun userDao(): UserDao
}