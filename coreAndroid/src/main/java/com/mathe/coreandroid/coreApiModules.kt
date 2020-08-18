package com.mathe.coreandroid

import com.mathe.coreandroid.remote.api.BitcoinMarketApi
import com.mathe.coreandroid.remote.api.CentralBankApi
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val MARKET_BITCOIN = "MARKET_BITCOIN"
const val CENTRAL_BANK = "CENTRAL_BANK"

val coreApiModules = module {
    single(MARKET_BITCOIN.toQualifier()) {
        Retrofit.Builder()
            .baseUrl(BuildConfig.MARKET_BITCOIN_URL)
            .addConverterFactory(get())
            .build()
    } bind Retrofit::class

    single(CENTRAL_BANK.toQualifier()) {
        Retrofit.Builder()
            .baseUrl(BuildConfig.MARKET_BITCOIN_URL)
            .addConverterFactory(get())
            .build()
    } bind Retrofit::class

    single {
        GsonConverterFactory.create()
    } bind Converter.Factory::class

    factory { get<Retrofit>(MARKET_BITCOIN.toQualifier()).create(BitcoinMarketApi::class.java) }
    factory { get<Retrofit>(CENTRAL_BANK.toQualifier()).create(CentralBankApi::class.java) }

}


fun String.toQualifier() = named(this)