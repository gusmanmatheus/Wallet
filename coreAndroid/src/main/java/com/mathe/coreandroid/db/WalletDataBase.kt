package com.mathe.coreandroid.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mathe.coreandroid.db.model.UserEntity
import com.mathe.coreandroid.db.model.WalletEntity

@Database(
    entities = [UserEntity::class,
        WalletEntity::class],
    version = 1
)
abstract class WalletDataBase() : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun walletDao(): WalletDao
}
