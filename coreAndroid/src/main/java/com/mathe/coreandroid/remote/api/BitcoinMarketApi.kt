package com.mathe.coreandroid.remote.api

import com.mathe.domain.BitcoinMarketPrice
import com.mathe.domain.Resources
 import retrofit2.Call
import retrofit2.http.GET

interface BitcoinMarketApi {
    @GET("ticker")
    fun getBitcoin(): Call<BitcoinMarketPrice>
}