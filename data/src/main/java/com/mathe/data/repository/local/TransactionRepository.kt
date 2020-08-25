package com.mathe.data.repository.local

import com.mathe.domain.Transaction
import com.mathe.domain.datasource.TransactionDataSource

class TransactionRepository(private val transactionDataSource: TransactionDataSource):TransactionDataSource {
    override suspend fun getAll(idUser: Long): List<Transaction> {
        return transactionDataSource.getAll(idUser)
    }

    override suspend fun salve(transaction: Transaction) {
        transactionDataSource.salve(transaction)
    }
}