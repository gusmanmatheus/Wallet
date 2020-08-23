package com.mathe.coreandroid.datasource.remote

import android.util.Log
import com.mathe.core.interactors.americaPattern
import com.mathe.core.interactors.getDatePast
import com.mathe.coreandroid.remote.api.BitcoinMarketApi
import com.mathe.coreandroid.remote.api.CentralBankApi
import com.mathe.domain.Resources
import com.mathe.domain.datasource.QuotationsDataSource
import retrofit2.await
import java.util.*

class RemoteQuotationDataSource(
    private val bitcoinMarketApi: BitcoinMarketApi,
    private val centralBankApi: CentralBankApi
) : QuotationsDataSource {
    override suspend fun getDollar(): Resources<Double?> {
        return try {
            val centralBankApi =
                centralBankApi.getDollarValue("'${Date().getDatePast(2).americaPattern()}'")
            val value = centralBankApi.await()
            Resources.successResponse(value.quotation())
        } catch (e: Exception) {
            Log.i("error", e.message ?: "erro vazio")
            Resources.errorResponse(e.message)
        }
    }

    override suspend fun getBitcoin(): Resources<Double?> {
        return try {
            val bitcoin = bitcoinMarketApi.getBitcoin()
            val price = bitcoin.await()
            Resources.successResponse(price.price())
        } catch (e: Exception) {
            Log.i("error", e.message ?: "erro vazio")
            Resources.errorResponse(e.message)
        }
    }
}
