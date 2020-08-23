package com.mathe.domain

data class Wallet(
    val id: Long = 0,
    val userId: Long = 0,
    var britta: Double,
    var real: Double,
    var bitcoin: Double
) {
    companion object {
        fun create(userId: Long) =
            Wallet(userId = userId, britta = 0.0, real = 100000.00, bitcoin = 0.0)
    }
}


