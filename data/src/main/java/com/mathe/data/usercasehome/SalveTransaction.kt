package com.mathe.data.usercasehome

import com.mathe.data.repository.local.TransactionRepository
import com.mathe.domain.Transaction

class SalveTransaction(private val transactionRepository: TransactionRepository) {
  suspend operator fun invoke(transaction: Transaction) {
        transactionRepository.salve(transaction)
    }
}