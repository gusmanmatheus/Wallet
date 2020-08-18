package com.example.home

import com.mathe.coreandroid.datasource.RemoteQuotationDataSource
import com.mathe.data.repository.local.QuotationRepository
import com.mathe.data.usercasehome.GetQuotationBitcoin
import com.mathe.data.usercasehome.GetQuotationDollar
import com.mathe.domain.datasource.QuotationsDataSource
import org.koin.dsl.module

val homeModules = module {
    factory {
        factory<QuotationsDataSource> {
            RemoteQuotationDataSource(
                bitcoinMarketApi = get(),
                centralBankApi = get()
            )
        }
        factory { QuotationRepository(quotationsDataSource = get()) }
        factory {
            GetQuotationBitcoin(
                quotationRepository = get()
            )
        }
        factory {
            GetQuotationDollar(
                quotationRepository = get()
            )
        }
    }
}