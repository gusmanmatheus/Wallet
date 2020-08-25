package com.mathe.domain.datasource

import com.mathe.domain.Transaction

interface TransactionDataSource {
   suspend fun getAll(idUser:Long): List<Transaction>
   suspend fun salve(transaction: Transaction)
}