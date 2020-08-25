package com.mathe.data.repository.local

import com.mathe.domain.Wallet
import com.mathe.domain.datasource.WalletDataSource

class WalletRepository(private val walletDataSource: WalletDataSource):WalletDataSource {
    override suspend fun getWallet(idUser: Long): Wallet {
       return  walletDataSource.getWallet(idUser)
    }

    override suspend fun updateWallet(wallet: Wallet):Int {
        return walletDataSource.updateWallet(wallet)
     }

    override suspend fun insertWallet(wallet: Wallet):Long {
        return walletDataSource.insertWallet(wallet)
    }
}