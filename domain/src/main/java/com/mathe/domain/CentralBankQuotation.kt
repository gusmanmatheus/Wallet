package com.mathe.domain

data class CentralBankQuotation(val value:List<Value>){
    fun quotation():Double?{
        return  value.firstOrNull()?.cotacaoCompra
    }
}

class Value(val cotacaoCompra: Double)