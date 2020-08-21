package com.mathe.data.usercaselogin

import com.mathe.data.repository.local.WalletRepository
import com.mathe.domain.Wallet

class CreateNewWallet(private val walletRepository: WalletRepository) {
    suspend operator fun invoke(wallet: Wallet): Long {
        return walletRepository.insertWallet(wallet)
    }
}