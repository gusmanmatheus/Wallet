package com.mathe.coreandroid.datasource

import android.util.Log
import com.mathe.core.interactors.americaPattern
import com.mathe.core.interactors.getDatePast
import com.mathe.coreandroid.remote.api.BitcoinMarketApi
import com.mathe.coreandroid.remote.api.CentralBankApi
import com.mathe.domain.datasource.QuotationsDataSource
import retrofit2.await
import java.util.*

class RemoteQuotationDataSource(
    private val bitcoinMarketApi: BitcoinMarketApi,
    private val centralBankApi: CentralBankApi
) : QuotationsDataSource {
    override suspend fun getDollar(): Double {
        return try {
            val centralBankApi =
                centralBankApi.getDollarValue(Date().getDatePast(1).americaPattern())
            val value = centralBankApi.await()
            value.quotation() ?: 0.0
        } catch (e: Exception) {
            Log.i("error", e.message ?: "erro vazio")
            0.0
        }
    }

    override suspend fun getBitcoin(): Double {
        return try {
            val bitcoin = bitcoinMarketApi.getBitcoin()
            val price = bitcoin.await()
            return price.price() ?: 0.0
        } catch (e: Exception) {
            Log.i("error", e.message ?: "erro vazio")
            0.0
        }
    }
}


