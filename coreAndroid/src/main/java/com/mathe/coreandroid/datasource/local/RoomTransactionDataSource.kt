package com.mathe.coreandroid.datasource.local

import com.mathe.coreandroid.db.TransactionDao
import com.mathe.coreandroid.db.model.TransactionEntity
import com.mathe.domain.Transaction
import com.mathe.domain.datasource.TransactionDataSource

class RoomTransactionDataSource(private val transactionDao: TransactionDao) :
    TransactionDataSource {
    override suspend fun getAll(idUser: Long): List<Transaction> {
        val list = transactionDao.getAll(idUser)
        return list.map { transaction -> transaction.toTransaction() }
    }

    override suspend fun salve(transaction: Transaction) {
        transactionDao.salve(transaction.toTransactionEntity())
    }

    private fun Transaction.toTransactionEntity() =
        TransactionEntity(
            buyType = buyType,
            buyValue = buyValue,
            sellType = sellType,
            sellValue = sellValue,
            date = date,
            userId = userId
        )

    private fun TransactionEntity.toTransaction() =
        Transaction(id, buyType, buyValue, sellType, sellValue, date, userId)
}
