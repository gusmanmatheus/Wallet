package com.example.home

import com.mathe.coreandroid.datasource.remote.RemoteQuotationDataSource
import com.mathe.data.repository.remote.QuotationRepository
import com.mathe.data.usercasehome.GetQuotationBitcoin
import com.mathe.data.usercasehome.GetQuotationDollar
import com.mathe.data.usercasehome.GetWallet
import com.mathe.data.usercaselogin.CreateNewWallet
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
        factory {
            QuotationRepository(
                quotationsDataSource = get()
            )
        }
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