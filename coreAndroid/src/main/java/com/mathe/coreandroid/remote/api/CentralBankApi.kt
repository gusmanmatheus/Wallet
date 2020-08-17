package com.mathe.coreandroid.remote.api

import com.mathe.domain.CentralBankQuotation
import com.mathe.domain.Resources
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CentralBankApi {
    @GET("CotacaoDolarDia(dataCotacao=@dataCotacao)?format=json")
    fun getDollarValue(
        @Query("@dataCotacao", encoded = true)
        dataCotacao: String
    ): Call<CentralBankQuotation>
}