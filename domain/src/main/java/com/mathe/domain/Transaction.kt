package com.mathe.domain

import java.util.*

data class Transaction(
    val buyType: String,
    val buyValue: Double,
    val sellType: String,
    val sellValue: Double,
    val date: Date,
    val userId: Long
)