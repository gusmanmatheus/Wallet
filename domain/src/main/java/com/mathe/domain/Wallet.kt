package com.mathe.domain

data class Wallet(
    val userId: Long = 0,
    val britta: Double,
    val real: Double,
    val bitcoin: Double
) {
    companion object {
        fun create(id: Long) = Wallet(userId = id, britta = 0.0, real = 100000.00, bitcoin = 0.0)
    }
}


