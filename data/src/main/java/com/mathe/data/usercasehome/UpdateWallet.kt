package com.mathe.data.usercasehome

import com.mathe.data.repository.local.WalletRepository
import com.mathe.domain.Wallet

class UpdateWallet(private val walletRepository: WalletRepository) {
    suspend operator fun invoke(wallet: Wallet):Int {
        return walletRepository.updateWallet(wallet)
    }
}