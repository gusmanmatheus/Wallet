package com.mathe.domain.datasource

interface QuotationsDataSource {
    suspend fun getDollar(): Double
    suspend fun getBitcoin(): Double
}