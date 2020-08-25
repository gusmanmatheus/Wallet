package com.mathe.domain

import java.util.*

data class Transaction(
    val id:Long = 0,
    val buyType: String,
    val buyValue: Double,
    val sellType: String,
    val sellValue: Double,
    val date: String,
    val userId: Long = 0
)