package com.example.home

import com.mathe.coreandroid.datasource.RemoteQuotationDataSource
import com.mathe.data.repository.local.QuotationRepository
import com.mathe.data.usercaselogin.GetQuotationBitcoin
import com.mathe.data.usercaselogin.GetQuotationDollar
import com.mathe.domain.datasource.QuotationsDataSource
import org.koin.dsl.module

val homeModules = module {
    factory {
        factory<QuotationsDataSource> { RemoteQuotationDataSource(get(), get()) }
        factory { QuotationRepository(get()) }
        factory { GetQuotationBitcoin(get()) }
        factory { GetQuotationDollar(get()) }
    }
}