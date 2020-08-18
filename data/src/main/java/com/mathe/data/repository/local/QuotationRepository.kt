package com.mathe.data.repository.local

import com.mathe.domain.Resources
import com.mathe.domain.datasource.QuotationsDataSource

class QuotationRepository(private val quotationsDataSource: QuotationsDataSource):QuotationsDataSource {
    override suspend fun getDollar(): Resources<Double>?{
        return quotationsDataSource.getDollar()
    }

    override suspend fun getBitcoin():  Resources<Double>? {
        return quotationsDataSource.getBitcoin()
    }
}