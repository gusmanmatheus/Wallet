package com.mathe.coreandroid.datasource.local

import com.mathe.coreandroid.db.WalletDao
import com.mathe.coreandroid.db.model.WalletEntity
import com.mathe.domain.Wallet
import com.mathe.domain.datasource.WalletDataSource

class RoomWalletDataSource(private val walletDao: WalletDao) : WalletDataSource {
    override suspend fun getWallet(idUser: Long): Wallet {
        val wallet = walletDao.getWallet(idUser)
        return wallet.toWallet()
    }

    override suspend fun updateWallet(wallet: Wallet): Int {
        return walletDao.updateWallet(wallet.toWalletEntity())
    }

    override suspend fun insertWallet(wallet: Wallet): Long {
        return walletDao.insertWallet(wallet.toWalletEntity())
    }

    private suspend fun Wallet.toWalletEntity() =
        WalletEntity(userId = userId, britta = britta, real = real, bitcoin = bitcoin)

    private suspend fun WalletEntity.toWallet() = Wallet(userId, britta, real, bitcoin)
}