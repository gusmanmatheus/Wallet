package com.mathe.data.usercasehome

import com.mathe.data.repository.local.WalletRepository
import com.mathe.domain.Wallet

class GetWallet(private val walletRepository: WalletRepository) {
    suspend operator fun invoke(idUser: Long): Wallet {
        return walletRepository.getWallet(idUser)
    }
}