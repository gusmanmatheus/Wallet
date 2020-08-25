package com.mathe.domain.datasource

import com.mathe.domain.Wallet

interface WalletDataSource {
    suspend fun getWallet(idUser: Long): Wallet
    suspend fun updateWallet(wallet: Wallet):Int
    suspend fun insertWallet(wallet: Wallet):Long
}