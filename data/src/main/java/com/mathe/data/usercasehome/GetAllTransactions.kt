package com.mathe.data.usercasehome

import com.mathe.data.repository.local.TransactionRepository
import com.mathe.domain.Transaction

class GetAllTransactions(private val transactionRepository: TransactionRepository) {
    suspend operator fun invoke(idUser: Long): List<Transaction> {
        return transactionRepository.getAll(idUser)
    }
}