package com.mathe.domain.datasource

import com.mathe.domain.Resources


interface QuotationsDataSource {
    suspend fun getDollar(): Resources<Double>?
    suspend fun getBitcoin(): Resources<Double>?
}