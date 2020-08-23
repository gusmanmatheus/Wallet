package com.mathe.core.interactors

import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

fun String.makeConvert(thisCambio: Double, toCambio: Double): String{
    val coinsConvert = if (this.isBlank()) 0.0 else this.toDouble()
    return (coinsConvert * (thisCambio / toCambio)).toBigDecimal().formatMoneyText()
}


fun BigDecimal.formatMoneyText(): String {
    val fmt = NumberFormat.getInstance(Locale("por", "BR")) as DecimalFormat
    fmt.isGroupingUsed = true
    fmt.minimumFractionDigits = 2
    fmt.maximumFractionDigits = 2
    return fmt.format(this)
}


fun String.cleanMoneyText(): Double {
    return if (this.isNotEmpty()) {
        this.replace("[.]".toRegex(), "").replace("[,]".toRegex(), ".").toDouble()
    } else {
        0.0
    }
}
