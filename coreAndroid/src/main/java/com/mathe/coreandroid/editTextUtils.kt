package com.mathe.coreandroid

import android.widget.EditText
import com.mathe.core.interactors.formatMoneyText
import java.math.BigDecimal

fun EditText.maskValue( ): String {
    val typedText = this.editableText.toString()
    val parsed: BigDecimal

    parsed = if (typedText.isEmpty()) {
        BigDecimal("0.00")
    } else {
        val cleanString = typedText.replace("[,. ]".toRegex(), "")
        BigDecimal(cleanString).divide(BigDecimal("100"))
    }
    return parsed.formatMoneyText()
}