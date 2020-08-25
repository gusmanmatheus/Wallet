package com.mathe.coreandroid.db

import androidx.room.*
import com.mathe.coreandroid.db.model.WalletEntity
import com.mathe.domain.Wallet

@Dao
interface WalletDao {
    @Query("SELECT * FROM wallet WHERE USER_ID = :id")
    suspend fun getWallet(id: Long): WalletEntity

    @Update
    suspend fun updateWallet(wallet: WalletEntity): Int

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertWallet(wallet: WalletEntity): Long
}