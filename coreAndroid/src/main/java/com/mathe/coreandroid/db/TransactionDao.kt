package com.mathe.coreandroid.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mathe.coreandroid.db.model.TransactionEntity

@Dao
interface TransactionDao {
    @Query("SELECT * FROM `TRANSACTION` WHERE USER_ID = :idUser")
    suspend fun getAll(idUser: Long): List<TransactionEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun salve(transaction: TransactionEntity)
}