package com.mathe.data.repository.local

import com.mathe.domain.datasource.QuotationsDataSource

class QuotationRepository(private val quotationsDataSource: QuotationsDataSource):QuotationsDataSource {
    override suspend fun getDollar(): Double {
        return quotationsDataSource.getDollar()
    }

    override suspend fun getBitcoin(): Double {
        return quotationsDataSource.getBitcoin()
    }
}