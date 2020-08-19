package com.example.home

import androidx.lifecycle.ViewModel
import com.mathe.data.usercasehome.GetQuotationBitcoin
import com.mathe.data.usercasehome.GetQuotationDollar

class HomeViewModel(
    val getQuotationBitcoin: GetQuotationBitcoin,
    val getQuotationDollar: GetQuotationDollar
) : ViewModel() {


    fun getCambio() {}
    fun getUserActive() {}
    fun getWallet() {}
    fun updateWallet(real: String, britta: String, bitcoin: String) {}
    fun convert(cambio: Cambio) {}
}

enum class Cambio {
    RealToBritta,
    RealToBitCoin,
    BrittaToReal,
    BrittaToBitcoin,
    BitcoinToBritta,
    BitcoinToReal

}