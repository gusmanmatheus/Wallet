package com.mathe.domain

class BitcoinMarketPrice (private val ticker:Ticker){
    fun price(): Double? {
        return  ticker.open
    }
}
data class Ticker(val open:Double)
