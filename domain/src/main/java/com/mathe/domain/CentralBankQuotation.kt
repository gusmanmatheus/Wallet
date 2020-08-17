package com.mathe.domain

data class CentralBankQuotation(val value:List<Value>){
    fun quotation():Double?{
        return value.firstOrNull()?.quotation
    }
}

class Value(val quotation: Double)